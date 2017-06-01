package com.example.login1.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.example.login1.API.myapi;


/**
 *
 */
public class UDPHelper implements Runnable {
    private static final String TAG = UDPHelper.class.getSimpleName();
    Handler handler;
    private DatagramSocket socketUDP=null;
    private String message1,revData=null;
    private boolean isContinue=false;
	DatagramPacket p ;
	byte data[];
    public UDPHelper(Handler handler) {
		super();
		this.handler = handler;
	}
    public String getMessage1() {
		return message1;
	}

	public void setMessage1(String message1) {
		this.message1 = message1;
	}
    @Override
    public void run() {
        //新建一个socket
		try {
			socketUDP = new DatagramSocket(myapi.PORT);
			socketUDP.setSoTimeout(10000);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//指明服务器IP地址
		InetAddress local = null;  
		try {  
		    // 服务器端IP  
		    local = InetAddress.getByName(myapi.MY_IP);
		} catch (UnknownHostException e) {  
		    e.printStackTrace();  
		}

		while (true)
		{
			 if(message1!=null){
		    	 //将发送内容转换成字节
		        int msg_length = message1.length();  
		        byte[] messageByte = message1.getBytes(); 
		        //创建packet对象发送数据
				 p = new DatagramPacket(messageByte, msg_length, local,myapi.PORT);
				 if (socketUDP!=null){
					 try {
						 socketUDP.send(p);
						 Log.e("发送","成功");
					 } catch (IOException e) {
						 e.printStackTrace();
					 }
				 }


		        message1=null;
		
		    }
			

			
		    data = new byte[1024];
			if(p!=null&&socketUDP!=null) {
				try {

					p = new DatagramPacket(data, data.length);
					socketUDP.receive(p);
					Log.e("判断address", p.getAddress().toString());
					if (p.getAddress().toString() != null) {
						revData = new String(p.getData(), p.getOffset(), p.getLength());
						Message msg = prepareMessage(revData);
						// message将被添加到主线程的MQ中
						handler.sendMessage(msg);
					}

					//handler.sendEmptyMessage(0);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 任务完成后通知activity更新UI
		    if (isContinue) {
				//socketUDP.close();
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}  
    }
    
    //定义设置isContinue变量为true的方法
	public void setContinue(){
		if(socketUDP!=null){
			socketUDP.close();
		}else {}
		this.isContinue=true;
	}
	
	
    private Message prepareMessage(String str) {
        Message result = handler.obtainMessage();
        Bundle data = new Bundle();
        data.putString("message", str);
        result.setData(data);
        return result;
    }
	
}