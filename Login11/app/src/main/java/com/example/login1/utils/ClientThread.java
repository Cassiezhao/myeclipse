package com.example.login1.utils;

/**
 * Created by hammer on 2016/12/27.
 */
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.example.login1.API.myapi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ClientThread implements Runnable {
    public static Socket s=null;
    // 定义向UI线程发送消息的Handler对象
    Handler handler;
    // 定义接收UI线程的Handler对象
    public static Handler revHandler;
    // 该线程处理Socket所对用的输入输出流
    private OutputStream os = null;
    private InputStream in = null;
    private byte[] buf;

    public ClientThread(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        s = new Socket();
        try {
            s.connect(new InetSocketAddress(myapi.MY_IP, myapi.PORT), 5000);
//            s.setKeepAlive(false);
            in = s.getInputStream();
            os = s.getOutputStream();
            buf = new byte[1024*1024];
            // 启动一条子线程来读取服务器相应的数据
            new Thread() {
                @Override
                public void run() {
                    int len = 0 ;
                    // 不断的读取Socket输入流的内容
                    try {
                        while ((len = in.read(buf)) != 0) {
                            // 每当读取到来自服务器的数据之后，发送的消息通知程序
                            // 界面显示该数据
                            if (len>0){
                                String show = new String(buf, 0, len,"gbk");
                                Message msg = new Message();
                                msg.what = 0x123;
                                msg.obj = show;
                                handler.sendMessage(msg);
                            }

                        }
                    } catch (IOException io) {
                        io.printStackTrace();
                    }
                }

            }.start();
            // 为当前线程初始化Looper
            Looper.prepare();

            // 创建revHandler对象
            revHandler = new Handler() {

                @Override
                public void handleMessage(Message msg) {
                    // 接收到UI线程的中用户输入的数据
                    if (msg.what == 0x345) {
                        // 将用户在文本框输入的内容写入网络
                        try {
                            os.write((msg.obj.toString() + "\r\n").getBytes("gbk"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

            };
            // 启动Looper
            Looper.loop();

        } catch (SocketTimeoutException e) {
            Message msg = new Message();
            msg.what = 0x123;
            msg.obj = "网络连接超时";
            handler.sendMessage(msg);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    //关闭资源
    public void colseall(){
        try {
            if (in!=null){
                in.close();
//                ToastUtils.toast("inc");
            }
            if (os!=null){
                os.close();
//                ToastUtils.toast("osc");
            }
            if (s!=null){
                s.close();
//                ToastUtils.toast("sc");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}