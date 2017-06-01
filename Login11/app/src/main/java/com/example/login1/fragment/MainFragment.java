package com.example.login1.fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.login1.API.myapi;
import com.example.login1.FCActivity;
import com.example.login1.R;
import com.example.login1.database.MySQLiteOpenHelper;
import com.example.login1.utils.ClientThread;
import com.example.login1.utils.GETTime;
import com.xaccp.library.util.ToastUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {
    // TODO: 2017/3/6--------------------------------------------------
    private static final String TAG = "MainFragment";
    private ConnectThread mConnectThread=null;
    public ConnectedThread mConnectedThread;

    private BluetoothAdapter bluetoothAdapter;
    private final UUID MY_UUID = UUID.fromString(myapi.uuid);
    private BluetoothDevice device;
    // TODO: 2017/3/6--------------------------------------------------

    MySQLiteOpenHelper openHelper;
    SQLiteDatabase database;
    Cursor cursor;
    private String username, userpassword, Phone, logintime, DESkey, tourists, DeviceID, result, pingjiaValue11;
    private String provider = null, BTPos = "0", message = null, jindu, weidu, RMID, RMID1, RM, RMNAME,uprenshu="0";
    private TextView ut;
    private LocationManager locationManager;
    private Location location;
    private boolean stopchuankou = false;
    // 定义与服务器通信的子线程
    ClientThread clientThread;
    private Handler handler4, handler;
    Thread mainThread;

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
                handler4 = new MyHandler3();
                clientThread = new ClientThread(handler4);
                // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
                mainThread = new Thread(clientThread);
                mainThread.start();
            } else {
                ToastUtils.toast("网络不可用");
            }
        }
    }

    //=========================================================================
    // ========================================================================
    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        openHelper = new MySQLiteOpenHelper(getActivity(), 1);
        database = openHelper.getWritableDatabase();
        locationManager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
        //=====================================================================
        intentFilter = new IntentFilter();
        //addAction
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceive = new NetworkChangeReceive();
        getActivity().registerReceiver(networkChangeReceive, intentFilter);
        //=====================================================================
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        } else {
        }
        //=====================================================================
        // TODO: 2017/3/6--------------------------------------------------
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        device = bluetoothAdapter.getRemoteDevice(myapi.btadress);
        // TODO: 2017/3/6--------------------------------------------------
        initView(view);
        pingjia(view);
        return view;
    }

    // TODO: 2017/3/7 ---------------------------------------------------------
    public void connect(BluetoothDevice device) {
        Log.d(TAG, "connect to: " + device);
        // Start the thread to connect with the given device
        if (mConnectedThread!=null){
            mConnectThread.cancel();
            mConnectThread = null;
        }else {}
            mConnectThread = new ConnectThread(device);
            mConnectThread.start();

    }

    /**
     * This thread runs while attempting to make an outgoing connection with a
     * device. It runs straight through; the connection either succeeds or
     * fails.
     */
    private class ConnectThread extends Thread {
        private final BluetoothSocket mmSocket;
        //private final BluetoothDevice mmDevice;

        public ConnectThread(BluetoothDevice device) {
            //mmDevice = device;
            BluetoothSocket tmp = null;

            // Get a BluetoothSocket for a connection with the
            // given BluetoothDevice
            try {
                tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
            } catch (IOException e) {
                Log.e(TAG, "create() failed", e);
            }
            mmSocket = tmp;
        }

        public void run() {
            Log.i(TAG, "BEGIN mConnectThread");
            setName("ConnectThread");

            // Always cancel discovery because it will slow down a connection
            bluetoothAdapter.cancelDiscovery();

            // Make a connection to the BluetoothSocket
            try {
                // This is a blocking call and will only return on a
                // successful connection or an exception
                mmSocket.connect();
            } catch (IOException e) {

                Log.e(TAG, "unable to connect() socket", e);
                // Close the socket
                try {
                    mmSocket.close();
                } catch (IOException e2) {
                    Log.e(TAG,
                            "unable to close() socket during connection failure",
                            e2);
                }
                return;
            }

            mConnectThread = null;

            // Start the connected thread
            // Start the thread to manage the connection and perform
            // transmissions
            mConnectedThread = new ConnectedThread(mmSocket);
            mConnectedThread.start();

        }

        public void cancel() {
            try {
                mmSocket.close();
            } catch (IOException e) {
                Log.e(TAG, "close() of connect socket failed", e);
            }
        }
    }


    /**
     * This thread runs during a connection with a remote device. It handles all
     * incoming and outgoing transmissions.
     */
    private class ConnectedThread extends Thread {
        private final BluetoothSocket mmSocket;
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        public ConnectedThread(BluetoothSocket socket) {
            Log.d(TAG, "create ConnectedThread");
            mmSocket = socket;
            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            // Get the BluetoothSocket input and output streams
            try {
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) {
                Log.e(TAG, "temp sockets not created", e);
            }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        public void run() {
            Log.i(TAG, "BEGIN mConnectedThread");
            byte[] buffer = new byte[256];
            int bytes;

            // Keep listening to the InputStream while connected
            while (true) {
                try {
                    int count = mmInStream.read(buffer);
                    Message msg = new Message();
                    msg.obj = new String(buffer,0,count,"utf-8");
                    bthandler.sendMessage(msg);
                    // Read from the InputStream
//                    bytes = mmInStream.read(buffer);
//                    synchronized (mBuffer) {
//                        for (int i = 0; i < bytes; i++) {
//                            mBuffer.add(buffer[i] & 0xFF);
//                        }
//                    }
//                    mHandler.sendEmptyMessage(MSG_NEW_DATA);
                } catch (IOException e) {
                    Log.e(TAG, "disconnected", e);
                    break;
                }
            }
        }

        /**
         * Write to the connected OutStream.
         *
         *
         */
        public void write(String btsend) {
            try {
                mmOutStream.write(btsend.getBytes("utf-8"));
            } catch (IOException e) {
                Log.e(TAG, "Exception during write", e);
            }
        }

        public void cancel() {
            try {
                mmSocket.close();
            } catch (IOException e) {
                Log.e(TAG, "close() of connect socket failed", e);
            }
        }
    }
    // TODO: 2017/3/7 ---------------------------------------------------------

    //=================================================================================
    public void location2() {
        //======================================================================
        cursor = database.query(true, "tourists", new String[]{"_id", "tourists"}, null, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            uprenshu = cursor.getString(1);
        }
        //======================================================================
        if (((FCActivity) getActivity()).getPos() != null) {
            BTPos = ((FCActivity) getActivity()).getPos();
            ((FCActivity) getActivity()).setPos("0");
            if (BTPos=="0"){
                Log.e("meilanya","bufale");
            }else {
                // 然后发送给子线程Handler
                Message msg = new Message();
                msg.what = 0x345;
                msg.obj = "Command:Pos\r\n" + "DeviceID:" + DeviceID + "\r\n" + "Latitude:" + "" + "\r\n" + "Longitude:" + "" + "\r\n" + "BTPos:" + BTPos + "\r\n" + "Time:" + GETTime.curtime() + "\r\n"+"Tourists:"+uprenshu+"\r\n";
                //========================================================================================
                handler4 = new MyHandler3();
                clientThread = new ClientThread(handler4);
                // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
                mainThread = new Thread(clientThread);
                mainThread.start();
                if (clientThread.revHandler != null) {
                    clientThread.revHandler.sendMessage(msg);
                }
                //=========================================================================================
                Log.e("离蓝牙", BTPos + "更近");
            }
        } else {
            Log.e("没有", "蓝牙位置提供器");
        }
    }
    //=================================================================================

    public void location() {
        //======================================================================
        cursor = database.query(true, "tourists", new String[]{"_id", "tourists"}, null, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            uprenshu = cursor.getString(1);
        }
        //======================================================================
        //接着需要选择一个位置提供器来确定设备当前的位置，一个有三种方式。
        //获取有哪些位置提供器可用
        if (((FCActivity) getActivity()).getPos() != null) {
            BTPos = ((FCActivity) getActivity()).getPos();
            ((FCActivity) getActivity()).setPos("0");
            Log.e("离蓝牙", BTPos + "更近");
        } else {
            Log.e("没有", "蓝牙位置提供器");
        }
        //========================================================
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);//高精度
        criteria.setAltitudeRequired(false);//无海拔要求
        criteria.setBearingRequired(false);//无方位要求
        criteria.setCostAllowed(true);//允许产生资费
        criteria.setPowerRequirement(Criteria.POWER_LOW);//低功耗
        provider = locationManager.getBestProvider(criteria, true);//传入 true 就表示只有启用的位置提供器才会被返回。
//==============================================================================
//
//        List<String> providers = locationManager.getProviders(true);//传入 true 就表示只有启用的位置提供器才会被返回。
//        if (providers.contains(LocationManager.GPS_PROVIDER)) {
//            provider = LocationManager.GPS_PROVIDER;
//        }else {
//            //Toast.makeText(getActivity(), "没有可用的位置提供器",Toast.LENGTH_SHORT).show();
//            Log.e("location: ", "have no providers!");
//            // 然后发送给子线程Handler
//            Message msg = new Message();
//            msg.what = 0x345;
//            msg.obj = "Command:Pos\r\n" + "DeviceID:" + DeviceID + "\r\n" + "Latitude:" + "" + "\r\n" + "Longitude:" + "" + "\r\n" + "BTPos:" + BTPos + "\r\n" + "Time:" + GETTime.curtime() + "\r\n"+"Tourists:"+uprenshu+"\r\n";
//            //========================================================================================
//            handler4 = new MyHandler3();
//            clientThread = new ClientThread(handler4);
//            // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
//            mainThread = new Thread(clientThread);
//            mainThread.start();
//            if (clientThread.revHandler != null) {
//                clientThread.revHandler.sendMessage(msg);
//            }
//            //=========================================================================================
//            return;
//        }
        if (provider != null) {
            Log.e("位置提供器是：", provider);
        } else {
            //Toast.makeText(getActivity(), "没有可用的位置提供器",Toast.LENGTH_SHORT).show();
            Log.e("location: ", "have no providers!");
            // 然后发送给子线程Handler
            Message msg = new Message();
            msg.what = 0x345;
            msg.obj = "Command:Pos\r\n" + "DeviceID:" + DeviceID + "\r\n" + "Latitude:" + "" + "\r\n" + "Longitude:" + "" + "\r\n" + "BTPos:" + BTPos + "\r\n" + "Time:" + GETTime.curtime() + "\r\n"+"Tourists:"+uprenshu+"\r\n";
            //========================================================================================
            handler4 = new MyHandler3();
            clientThread = new ClientThread(handler4);
            // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
            mainThread = new Thread(clientThread);
            mainThread.start();
            if (clientThread.revHandler != null) {
                clientThread.revHandler.sendMessage(msg);
            }
            //=========================================================================================
            return;
        }
        try {
            location = locationManager.getLastKnownLocation(provider);//通过provider获取当前位置
            Log.e("获取当前", "位置");
        } catch (SecurityException e) {
            ToastUtils.toast("wrong getLastKnownLocation()");
        }

        if (location != null) {
            updatesqlite(location);
            jindu = "" + location.getLongitude();
            weidu = "" + location.getLatitude();
            //ToastUtils.toast("weizhi"+jindu+weidu);
            Log.e("weizhi", jindu + weidu);
            //DES加密
            //byte[] desEncode = DESUtil.jdkDESENcode("Command:Pos\r\n"+"PacketID:1\r\n"+"DeviceID:"+Device_ID+"\r\n"+"Latitude:"+weidu+"\r\n"+"Longitude:"+jindu+"\r\n"+"BTPos:"+BTPos+"\r\n"+"Time:"+curtime+"\r\n", DESkey);
            //UDPSend u4 = new UDPSend(DESUtil.convertByteToHexString(desEncode));
            //u2.setMessage("Command:Pos\r\n"+"DeviceID:"+DeviceID+"\r\n"+"Latitude:"+weidu+"\r\n"+"Longitude:"+jindu+"\r\n"+"BTPos:"+BTPos+"\r\n"+"Time:"+curtime+"\r\n");
            //getActivity().pos;
            message = "Command:Pos\r\n" + "DeviceID:" + DeviceID + "\r\n" + "Latitude:" + weidu + "\r\n" + "Longitude:" + jindu + "\r\n" + "BTPos:" + BTPos + "\r\n" + "Time:" + GETTime.curtime() + "\r\n"+"Tourists:"+uprenshu+"\r\n";
            Log.e("kankan", BTPos);
            // 然后发送给子线程Handler
            Message msg = new Message();
            msg.what = 0x345;
            msg.obj = message;
            //========================================================================================
            handler4 = new MyHandler3();
            clientThread = new ClientThread(handler4);
            // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
            mainThread = new Thread(clientThread);
            mainThread.start();
            if (clientThread.revHandler != null) {
                clientThread.revHandler.sendMessage(msg);
            }
            //=========================================================================================
        } else {
            // 然后发送给子线程Handler
            Message msg = new Message();
            msg.what = 0x345;
            msg.obj = "Command:Pos\r\n" + "DeviceID:" + DeviceID + "\r\n" + "Latitude:" + "" + "\r\n" + "Longitude:" + "" + "\r\n" + "BTPos:" + BTPos + "\r\n" + "Time:" + GETTime.curtime() + "\r\n"+"Tourists:"+uprenshu+"\r\n";
            //========================================================================================
            handler4 = new MyHandler3();
            clientThread = new ClientThread(handler4);
            // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
            mainThread = new Thread(clientThread);
            mainThread.start();
            if (clientThread.revHandler != null) {
                clientThread.revHandler.sendMessage(msg);
            }
            //=========================================================================================
        }
//        监听器：监听位置的变化
//        每隔10秒检测一次移动距离，当移动距离大于5米就调用监听器的onLocationChanged方法

        try {
            locationManager.requestLocationUpdates(provider, 10000, 1, listener);
        } catch (SecurityException e) {
            Toast.makeText(getActivity(), "wrong requestLocationUpdates", Toast.LENGTH_LONG).show();
        }

    }


    LocationListener listener = new LocationListener() {
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }

        @Override
        public void onLocationChanged(Location location) {
            //======================================================================
            cursor = database.query(true, "tourists", new String[]{"_id", "tourists"}, null, null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                uprenshu = cursor.getString(1);
            }
            //======================================================================
            if (((FCActivity) getActivity()).getPos() != null) {
                BTPos = ((FCActivity) getActivity()).getPos();
                ((FCActivity) getActivity()).setPos("0");
                Log.e("离蓝牙", BTPos + "更近");
            } else {
                Log.e("没有", "蓝牙位置提供器");
            }
            updatesqlite(location);
            jindu = "" + location.getLongitude();
            weidu = "" + location.getLatitude();
            Log.d("weizhi", jindu + weidu);
            //DES加密
            //byte[] desEncode1 = DESUtil.jdkDESENcode("Command:Pos\r\n"+"PacketID:1\r\n"+"DeviceID:"+Device_ID+"\r\n"+"Latitude:"+weidu+"\r\n"+"Longitude:"+jindu+"\r\n"+"BTPos:"+BTPos+"\r\n"+"Time:"+curtime+"\r\n", DESkey);
            //UDPSend u5 = new UDPSend(DESUtil.convertByteToHexString(desEncode1));
            message = "Command:Pos\r\n" + "DeviceID:" + DeviceID + "\r\n" + "Latitude:" + weidu + "\r\n" + "Longitude:" + jindu + "\r\n" + "BTPos:" + BTPos + "\r\n" + "Time:" + GETTime.curtime() + "\r\n"+"Tourists:"+uprenshu+"\r\n";
            Log.e("kankan", BTPos);
            // 然后发送给子线程Handler
            Message msg = new Message();
            msg.what = 0x345;
            msg.obj = message;
            //========================================================================================
            handler4 = new MyHandler3();
            clientThread = new ClientThread(handler4);
            // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
            mainThread = new Thread(clientThread);
            mainThread.start();
            if (clientThread.revHandler != null) {
                clientThread.revHandler.sendMessage(msg);
            }
            //=========================================================================================
        }
    };

    private void updatesqlite(Location location) {
        ContentValues values = new ContentValues();

        String lon = "" + location.getLongitude();
        String lat = "" + location.getLatitude();

        //创建数据库
        database = openHelper.getWritableDatabase();
        values.put("deviceid", DeviceID);
        values.put("username", username);
        values.put("longitude", lon);
        values.put("latitude", lat);
        values.put("BTpos", BTPos);
        values.put("time", GETTime.curtime());
        database.insert("jingwei", null, values);
        Log.d("数据库", "位置写入成功");
    }

    //
    private Runnable mTimeTask = new Runnable() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            location2();
            handler.postDelayed(mTimeTask, 10000);//10秒
        }
    };

    private void initView(View view) {
        handler = new Handler();
        handler.postDelayed(mTimeTask, 10000);//10秒
        ut = (TextView) view.findViewById(R.id.textView2);
        view.findViewById(R.id.peidui).setOnClickListener(this);
        view.findViewById(R.id.houtai).setOnClickListener(this);
        view.findViewById(R.id.pbtn).setOnClickListener(this);
        view.findViewById(R.id.msbtn).setOnClickListener(this);
        view.findViewById(R.id.exit).setOnClickListener(this);
        view.findViewById(R.id.gonglv).setOnClickListener(this);
        cursor = database.query(true, "fenpei", new String[]{"_id", "deviceid", "username", "password", "phone", "tourists", "key"}, null, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            DeviceID = cursor.getString(1);
            username = cursor.getString(2);
//            userpassword=cursor.getString(3);
            Phone = cursor.getString(4);
            tourists = cursor.getString(5);
            DESkey = cursor.getString(6);
            logintime = GETTime.curtime();
        }
        ut.setText("你好：" + username + "\n" + "登录时间：" + logintime);
        //打开线程
        handler4 = new MyHandler3();
        clientThread = new ClientThread(handler4);
        // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
        mainThread = new Thread(clientThread);
        mainThread.start();
        location();
    }

    class MyHandler3 extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // 如果消息来自子线程
            if (msg.what == 0x123) {
                result = msg.obj.toString();
                Log.e("result", result);
                judgement(result);
            }
        }
    }

    //创建一个判断的方法
    public void judgement(String msg) {
        ContentValues values = new ContentValues();

        //先进行DES解密
//        byte[] DESmsg = msg.getBytes();
//        byte[] desDecode = DESUtil.jdkDESDEcode(DESmsg, DESkey);
//        String Decodemsg = new String(desDecode);
        String Decodemsg = msg;
        int CNum = 0;
        //设置正则表达式
        String regex1 = ".*Command:(GotPos).*HaveMessage:(Yes).*MessageID:(.*).*Message:([\\s\\S]*).*";
        String regex2 = ".*Command:(GotPos).*HaveMessage:(No).*";
        String regex3 = ".*Command:(GotPos).*HaveMessage:(Yuyin).*MessageID:(.*).*MessageName:(.*).*";
        //String regex2 = ".*Command:(ChargeSuccess).*";
        //判断
        if (Decodemsg == null) {
            Log.d("没有接收", "到消息");
        } else if (Decodemsg.matches(regex1) == true) {
            CNum = 1;
        } else if (Decodemsg.matches(regex2) == true) {
            CNum = 2;
        } else if (Decodemsg.matches(regex3) == true) {
            CNum = 3;
        }

        switch (CNum) {
            case 1:
                RMID = Decodemsg.replaceAll(regex1, "$3");
                RM = Decodemsg.replaceAll(regex1, "$4");
                //首先要判断数据控中有没有这个消息，有了就回复id，没有就写入数据库
                cursor = database.query(true, "xiaoxi", new String[]{"_id", "deviceid", "messagesid", "messages", "time"}, null, null, null, null, null, null, null);
                while (cursor.moveToNext()) {
                    RMID1 = cursor.getString(2);
                    if (RMID == RMID1) {
                        // 然后发送给子线程Handler
                        Message msg1 = new Message();
                        msg1.what = 0x345;
                        msg1.obj = "Command:GotMsg" + "\r\n" + "DeviceID:" + DeviceID + "\r\n" + "MessageID:" + RMID1 + "\r\n";
                        //========================================================================================
                        handler4 = new MyHandler3();
                        clientThread = new ClientThread(handler4);
                        // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
                        mainThread = new Thread(clientThread);
                        mainThread.start();
                        if (clientThread.revHandler != null) {
                            clientThread.revHandler.sendMessage(msg1);
                        }
                        //=========================================================================================
                    }
                }
                values.put("deviceid", DeviceID);
                values.put("messagesid", RMID);
                values.put("messages", RM);
                values.put("time", GETTime.curtime());
                database.insert("xiaoxi", null, values);
                // 然后发送给子线程Handler
                Message msg2 = new Message();
                msg2.what = 0x345;
                msg2.obj = "Command:GotMsg" + "\r\n" + "DeviceID:" + DeviceID + "\r\n" + "MessageID:" + RMID + "\r\n";
                //========================================================================================
                handler4 = new MyHandler3();
                clientThread = new ClientThread(handler4);
                // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
                mainThread = new Thread(clientThread);
                mainThread.start();
                if (clientThread.revHandler != null) {
                    clientThread.revHandler.sendMessage(msg2);
                }
                //=========================================================================================
                ToastUtils.toast("收到消息了，请注意查收！");
                break;
            case 2:
                Log.e("没有短消息", "推送");
                break;
            case 3:
                RMID = Decodemsg.replaceAll(regex3, "$3");
                RMNAME = Decodemsg.replaceAll(regex3, "$4");
                //首先要判断数据控中有没有这个消息，有了就回复id，没有就写入数据库
                cursor = database.query(true, "yuyinxiaoxi", new String[]{"_id", "deviceid", "messagesid", "messagesname", "time"}, null, null, null, null, null, null, null);
                while (cursor.moveToNext()) {
                    RMID1 = cursor.getString(2);
                    if (RMID == RMID1) {
                        // 然后发送给子线程Handler
                        Message msg3 = new Message();
                        msg3.what = 0x345;
                        msg3.obj = "Command:GotMsg" + "\r\n" + "DeviceID:" + DeviceID + "\r\n" + "MessageID:" + RMID1 + "\r\n";
                        //========================================================================================
                        handler4 = new MyHandler3();
                        clientThread = new ClientThread(handler4);
                        // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
                        mainThread = new Thread(clientThread);
                        mainThread.start();
                        if (clientThread.revHandler != null) {
                            clientThread.revHandler.sendMessage(msg3);
                        }
                        //=========================================================================================
                    }
                }
                values.put("deviceid", DeviceID);
                values.put("messagesid", RMID);
                values.put("messagesname", RMNAME);
                values.put("time", GETTime.curtime());
                database.insert("yuyinxiaoxi", null, values);
//                fileMavHttp yuyin=new fileMavHttp();
//                yuyin.filefind(RMNAME);
                // 然后发送给子线程Handler
                Message msg4 = new Message();
                msg4.what = 0x345;
                msg4.obj = "Command:GotMsg" + "\r\n" + "DeviceID:" + DeviceID + "\r\n" + "MessageID:" + RMID + "\r\n";
                //========================================================================================
                handler4 = new MyHandler3();
                clientThread = new ClientThread(handler4);
                // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
                mainThread = new Thread(clientThread);
                mainThread.start();
                if (clientThread.revHandler != null) {
                    clientThread.revHandler.sendMessage(msg4);
                }
                //=========================================================================================
                ToastUtils.toast("收到语音消息了，请注意查收！");
                break;
            default:
                ToastUtils.toast("主界面没有匹配命令");
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.peidui:
                // TODO: 2017/3/8 ----------------取消蓝牙连接------------------
                if(mConnectThread!=null)
                {
                    mConnectThread.cancel();
                }else {}
                if (mConnectedThread!=null)
                {
                    mConnectedThread.cancel();
                }else {}
                // TODO: 2017/3/8 ----------------取消蓝牙连接------------------
//                //配对信息
//                MatchFragment sd = new MatchFragment();
//                Bundle bundle2 = new Bundle();
//                bundle2.putString("tts", tourists);
//                sd.setArguments(bundle2);
                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)  //将当前fragment加入到返回栈中
                        .replace(R.id.fl_container, new MatchFragment()).commit();
                break;
            case R.id.houtai:
                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)  //将当前fragment加入到返回栈中
                        .replace(R.id.fl_container, new PhoneFragment1()).commit();
                break;
            case R.id.pbtn:
                //修改密码
                //===================================
                handler4.removeCallbacksAndMessages(null);
                clientThread.colseall();
                //===================================
                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)  //将当前fragment加入到返回栈中
                        .replace(R.id.fl_container, new PassFragment()).commit();
                break;
            case R.id.msbtn:
                //短消息
                MessageFragment a = new MessageFragment();
                Bundle bundle = new Bundle();
                bundle.putString("phone", Phone);
                a.setArguments(bundle);
                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)  //将当前fragment加入到返回栈中
                        .replace(R.id.fl_container, a).commit();
                break;
            case R.id.exit:
                mydialog();
                break;
            case R.id.gonglv:
                // TODO: 2017/3/8 ----------------取消蓝牙连接------------------
                if(mConnectThread!=null)
                {
                    mConnectThread.cancel();
                }else {}
                if (mConnectedThread!=null)
                {
                    mConnectedThread.cancel();
                }else {}
                // TODO: 2017/3/8 ----------------取消蓝牙连接------------------
                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)  //将当前fragment加入到返回栈中
                        .replace(R.id.fl_container, new PowerCFragment()).commit();
                break;
            default:
                break;

        }
    }

    private void pingjia(View view) {

        // TODO: 2017/3/8 ------------------蓝牙发送消息-----------------
        connect(device);
        if(mConnectedThread !=null){
            mConnectedThread.write("getevaluation\r\n");
        }else {}
        // TODO: 2017/3/8 ------------------蓝牙发送消息-----------------
    }

    private Handler bthandler = new Handler() {
        public void handleMessage(Message msg) {
            ContentValues values = new ContentValues();
            //获取数据
            String dataString = (String) msg.obj;
            String mark = "\r\n";
            String[] strings = dataString.split(mark);//格式
            if (strings[0].equalsIgnoreCase("EXIT")) {
//                getFragmentManager().popBackStack();
                Log.e("banzi", "guanbi");
            } else {
                StringBuffer sb = new StringBuffer();
                if (strings[0] == "0") {
                    Log.e("没有人配对", "没有人评分");
                } else {
                    for (int i = 1; i < strings.length; i++) {
                        sb.append(strings[i] + ",");
                    }
                    String mysore = sb.toString();
                    String str = strings[0];
                    values.put("username", username);
                    values.put("tourists", str);
                    values.put("pingjiaxinxi", mysore);
                    database.insert("pingjia", null, values);
                }
            }

        }
    };
    //==================================dialog==============================
    private void mydialog(){
        //先new出一个监听器，设置好监听
        DialogInterface.OnClickListener dialogOnclicListener=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch(which){
                    case Dialog.BUTTON_POSITIVE:
                        // TODO: 2016/12/19 先注释了好操作
                        // TODO: 2017/3/8 ------------------蓝牙发送消息-----------------
                        connect(device);
                        if(mConnectedThread !=null){
                            mConnectedThread.write("logout\r\n");
                        }else {}
                        // TODO: 2017/3/8 ------------------蓝牙发送消息-----------------
                        //============================================================================
                        cursor = database.query(true, "pingjia", new String[]{"_id", "username", "tourists", "pingjiaxinxi", "time"}, null, null, null, null, null, null, null);
                        while (cursor.moveToNext()) {
                            if (cursor.getString(3) == null) {
                                pingjiaValue11 = "0,";
                            } else {
                                pingjiaValue11 = cursor.getString(3);
                            }
                        }
                        // 然后发送给子线程Handler
                        Message msg = new Message();
                        msg.what = 0x345;
                        msg.obj = "Command:xiaxian\r\n" + "DeviceID:" + DeviceID + "\r\n" + "Time:" + GETTime.curtime() + "\r\n" + "Evaluation:" + pingjiaValue11;
                        //========================================================================================
                        handler4 = new MyHandler3();
                        clientThread = new ClientThread(handler4);
                        // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
                        mainThread = new Thread(clientThread);
                        mainThread.start();
                        if (clientThread.revHandler != null) {
                            clientThread.revHandler.sendMessage(msg);
                        }
                        //=========================================================================================
                        handler.removeCallbacksAndMessages(null);
                        handler4.removeCallbacksAndMessages(null);
                        clientThread.colseall();
                        // TODO: 2017/3/8 ----------------取消蓝牙连接------------------
                        if(mConnectThread!=null)
                        {
                            mConnectThread.cancel();
                        }else {}
                        if (mConnectedThread!=null)
                        {
                            mConnectedThread.cancel();
                        }else {}
                        // TODO: 2017/3/8 ----------------取消蓝牙连接------------------
                        //============================================================================
                        getFragmentManager().popBackStack();
                        break;
                    case Dialog.BUTTON_NEGATIVE:
                        break;
                }
            }
        };
        //dialog参数设置
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());  //先得到构造器
        builder.setTitle("提示"); //设置标题
        builder.setMessage("是否确认退出?"); //设置内容
//        builder.setIcon(R.mipmap.ic_launcher);//设置图标，图片id即可
        builder.setPositiveButton("确认",dialogOnclicListener);
        builder.setNegativeButton("取消", dialogOnclicListener);
        builder.create().show();
    }
    //==================================dialog==============================

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(networkChangeReceive);
        if (locationManager != null) {
            try {
                locationManager.removeUpdates(listener);//关闭程序时将监听器移除
            } catch (SecurityException e) {
                Toast.makeText(getActivity(), "wrong removeUpdates", Toast.LENGTH_LONG).show();
            }
        }
//        cursor = database.query(true, "pingjia", new String[]{"_id", "username", "tourists", "pingjiaxinxi", "time"}, null, null, null, null, null, null, null);
//        while (cursor.moveToNext()) {
//            if (cursor.getString(3)==null){
//                pingjiaValue11 = "0";
//            }else {
//                pingjiaValue11 = cursor.getString(3);
//            }
//
//        }
//        // 然后发送给子线程Handler
//        Message msg = new Message();
//        msg.what = 0x345;
//        msg.obj = "Command:xiaxian\r\n" + "DeviceID:" + DeviceID + "\r\n" + "Time:" + GETTime.curtime() + "\r\n" + "Evaluation:" + pingjiaValue11;
//        //========================================================================================
//        handler4 = new MyHandler3();
//        clientThread = new ClientThread(handler4);
//        // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
//        mainThread = new Thread(clientThread);
//        mainThread.start();
//        if (clientThread.revHandler != null) {
//            clientThread.revHandler.sendMessage(msg);
//        }
        //=========================================================================================
//        handler.removeCallbacksAndMessages(null);
//        handler4.removeCallbacksAndMessages(null);
//        clientThread.colseall();
//        setchuankou();
//        //===================================
    }
}
