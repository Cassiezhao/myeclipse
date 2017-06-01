package com.example.login1.fragment;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login1.R;
import com.example.login1.database.MySQLiteOpenHelper;
import com.example.login1.utils.ClientThread;
import com.example.login1.utils.MD5Util;
import com.example.login1.utils.UDPHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class PassFragment extends Fragment{
    private EditText before,after,again;
    private String s1,s2,s3,pString,message,result,did;
    private Button commit,fanhui;
    private String Decodemsg;
    MySQLiteOpenHelper openHelper;
    SQLiteDatabase database;
    Cursor cursor;
    // 定义与服务器通信的子线程
    ClientThread clientThread;
    Handler handler5;
    Thread passThread;

    //=======================================================================
    private IntentFilter intentFilter;
    private NetworkChangeReceive networkChangeReceive;
    //=======================================================================
    class NetworkChangeReceive extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager)
                    getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()) {
//                Toast.makeText(getActivity(), "net is available", Toast.LENGTH_SHORT).show();
                handler5 = new MyHandler();
                clientThread = new ClientThread(handler5);
                // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
                passThread = new Thread(clientThread);
                passThread.start();
            } else {
                Toast.makeText(getActivity(), "网络不可用", Toast.LENGTH_SHORT).show();
            }
        }
    }
    //=========================================================================

    public PassFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pass, container, false);
        openHelper =new MySQLiteOpenHelper(getActivity(),1);
        database=openHelper.getWritableDatabase();
        //=====================================================================
        intentFilter = new IntentFilter();
        //addAction
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceive = new NetworkChangeReceive();
        getActivity().registerReceiver(networkChangeReceive, intentFilter);
        //=====================================================================
        initView(view);
        return view;
    }

    private void initView(View view) {
        cursor = database.query(true, "fenpei", new String[] {"_id","deviceid","username","password","phone","tourists","key"}, null, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            did = cursor.getString(1);
            pString = cursor.getString(3);
        }
        commit = (Button)view.findViewById(R.id.commit);
        fanhui = (Button)view.findViewById(R.id.fanhui);
        before = (EditText)view.findViewById(R.id.username_edit);
        after = (EditText)view.findViewById(R.id.again1);
        again = (EditText)view.findViewById(R.id.again2);

        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        commit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                handler5 = new MyHandler();
                clientThread = new ClientThread(handler5);
                // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
                passThread = new Thread(clientThread);
                passThread.start();
                /*
                try {
                    s1= MD5Util.md5Encode(before.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                */
                // TODO: 2016/12/16 还未加密
                s1 = before.getText().toString();
                s2=after.getText().toString();
                s3=again.getText().toString();
                if(s1.equals(pString)&&s2.equals(s3)){

                    //往服务器发送
                    // TODO: 2016/12/15 用不用把新密码替换到数据库 
                    message="Command:ChargePassword\r\n"+"DeviceID:"+did+"\r\n"+"Newpassword:"+s2+"\r\n";

                    // 然后发送给子线程Handler
                    Message msg = new Message();
                    msg.what = 0x345;
                    msg.obj = message;
                    //========================================================================================
                    handler5 = new MyHandler();
                    clientThread = new ClientThread(handler5);
                    // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
                    passThread = new Thread(clientThread);
                    passThread.start();
                    if (clientThread.revHandler!=null){
                        clientThread.revHandler.sendMessage(msg);
                    }
                    //=========================================================================================

                }else if(!s1.equals(pString)){
                    Toast.makeText(getActivity(), "与原始密码不一样，请重新输入！",Toast.LENGTH_LONG).show();
                }else if (!s2.equals(s3)) {
                    Toast.makeText(getActivity(), "两次修改密码不同，请重新输入！",Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // 如果消息来自子线程
            if (msg.what == 0x123) {
                result = msg.obj.toString();
                Log.e("result",result);
                judgement(result);
            }
        }
    }

    //创建一个判断的方法
    public void judgement(String msg) {

        //先进行DES解密
        //byte[] DESmsg = msg.getBytes();
        //byte[] desDecode = DESUtil.jdkDESDEcode(DESmsg, DESkey);
        //String Decodemsg = new String(desDecode);
        Decodemsg = msg;
        //设置正则表达式
        String regex1 = ".*Command:(ChargeSuccess).*";

        //判断
        if (Decodemsg==null) {
            Log.d("没有接收", "到消息");
        }else if (Decodemsg.matches(regex1)==true) {
            //===================================
            handler5.removeCallbacksAndMessages(null);
            clientThread.colseall();
//            passThread.interrupt();
//            passThread=null;
            //===================================
            Toast.makeText(getActivity(), "修改成功！",Toast.LENGTH_LONG).show();
            getFragmentManager().popBackStack();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(networkChangeReceive);
        //===================================
        handler5.removeCallbacksAndMessages(null);
        clientThread.colseall();
        //===================================
    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        handler5.removeCallbacksAndMessages(passThread);
//    }
}
