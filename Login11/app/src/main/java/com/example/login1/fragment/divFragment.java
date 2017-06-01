package com.example.login1.fragment;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
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
import android.widget.Toast;

import com.example.login1.API.myapi;
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
public class divFragment extends Fragment implements View.OnClickListener {
    // TODO: 2017/3/6--------------------------------------------------
    private static final String TAG = "divFragment";
    private ConnectThread mConnectThread=null;
    public ConnectedThread mConnectedThread;

    private BluetoothAdapter bluetoothAdapter;
    private final UUID MY_UUID = UUID.fromString(myapi.uuid);
    private BluetoothDevice device;
    // TODO: 2017/3/6--------------------------------------------------

    private int CNum = 0, ccount = -1;
    private String result,
            userNameValue1 = null, passwordValue1 = null, PhoneValue1 = null, TouristsValue1 = null, keyvalue1 = null;
    private String id;
    MySQLiteOpenHelper openHelper;
    SQLiteDatabase database;
    Cursor cursor, cursor1;
    // 定义与服务器通信的子线程
    ClientThread clientThread;
    Handler handler1;
    Thread divThread;


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
                handler1 = new MyHandler1();
                clientThread = new ClientThread(handler1);
                // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
                divThread = new Thread(clientThread);
                divThread.start();
                Toast.makeText(getActivity(), "网络可用", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "网络不可用", Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(networkChangeReceive);
    }
    //=========================================================================

    public divFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_div, container, false);
        //=====================================================================
        intentFilter = new IntentFilter();
        //addAction
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceive = new NetworkChangeReceive();
        getActivity().registerReceiver(networkChangeReceive, intentFilter);
        //=====================================================================
        // TODO: 2017/3/6--------------------------------------------------
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        device = bluetoothAdapter.getRemoteDevice(myapi.btadress);
        // TODO: 2017/3/6--------------------------------------------------
        initView(view);
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
        private  BluetoothSocket mmSocket;
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
//            try {
//                mmSocket =(BluetoothSocket) device.getClass().getMethod("createRfcommSocket", new Class[] {int.class}).invoke(device,1);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            }
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
                mmInStream.close();
                mmOutStream.close();
                mmSocket.close();
                mConnectedThread = null;
            } catch (IOException e) {
                Log.e(TAG, "close() of connect socket failed", e);
            }
        }
    }
    private Handler bthandler = new Handler(){
        public void handleMessage(Message msg) {
            ContentValues values = new ContentValues();
            String dataString = msg.obj.toString();
            Log.e("22222222", dataString);
            String mark = "\r\n";
            String[] strings = dataString.split(mark);//格式// ;
            id = strings[0];
            values.put("deviceid", id);
            database.insert("daoyoujiid", null, values);
            ToastUtils.toast("分配界面的" + dataString);
        }
    };
    // TODO: 2017/3/7 ---------------------------------------------------------

    private void initView(View view) {
        view.findViewById(R.id.divBtn).setOnClickListener(this);
        /**
         * 创建数据库
         */
        openHelper = new MySQLiteOpenHelper(getActivity(), 1);
        //创建数据库
        database = openHelper.getWritableDatabase();

        cursor1 = database.query(true, "daoyoujiid", new String[]{"_id", "deviceid"}, null, null, null, null, null, null, null);
        if (cursor1.getCount() == 0) {
            // TODO: 2017/3/8 ------------------蓝牙发送消息-----------------
            connect(device);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(mConnectedThread !=null){
                mConnectedThread.write("getid\r\n");
                Log.e(TAG, "向蓝牙发送getid成功");
            }else {}
            // TODO: 2017/3/8 ------------------蓝牙发送消息-----------------
        }

        cursor = database.query(true, "fenpei", new String[]{"_id", "deviceid", "username", "password", "phone", "tourists", "key"}, null, null, null, null, null, null, null);
        ccount = cursor.getCount();

        if (ccount == 0) {
            handler1 = new MyHandler1();
            clientThread = new ClientThread(handler1);
            // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
            divThread = new Thread(clientThread);
            divThread.start();

        } else {
            // TODO: 2017/3/8 ----------------取消蓝牙连接------------------
            bthandler.removeCallbacksAndMessages(null);
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
                    .replace(R.id.fl_container, new LoginFragment()).commit();
        }
    }

    class MyHandler1 extends Handler {
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

    public void judgement(String msg) {
        ContentValues values = new ContentValues();
        String regex1 = ".*Command:(Agree).*Username:(.*).*Userpassword:(.*).*ServerPhone:(.*).*Tourists:(.*).*key:(.*).*";
        String regex2 = ".*Command:(Deny).*";
        if (msg == null) {
            CNum = 3;
        } else if (msg.matches(regex1) == true) {
            CNum = 1;
        } else if (msg.matches(regex2) == true) {
            CNum = 2;
        }

        switch (CNum) {
            case 1:
                //匹配成功，发用户名和密码存一个变量
                userNameValue1 = msg.replaceAll(regex1, "$2");
                passwordValue1 = msg.replaceAll(regex1, "$3");
                PhoneValue1 = msg.replaceAll(regex1, "$4");
                TouristsValue1 = msg.replaceAll(regex1, "$5");
                keyvalue1 = msg.replaceAll(regex1, "$6");
                //写入数据库
                values.put("deviceid", id);
                values.put("username", userNameValue1);
                values.put("password", passwordValue1);
                values.put("phone", PhoneValue1);
                values.put("tourists", TouristsValue1);
                values.put("key", keyvalue1);
                database.insert("fenpei", null, values);
//                Toast.makeText(getActivity(), "分配成功！", Toast.LENGTH_SHORT).show();
                ToastUtils.toast("分配成功！");
                //===================================
                handler1.removeCallbacksAndMessages(null);
                clientThread.colseall();
//                divThread.interrupt();
//                divThread=null;
                //===================================
                // TODO: 2017/3/8 ----------------取消蓝牙连接------------------
                bthandler.removeCallbacksAndMessages(null);
                if(mConnectThread!=null)
                {
                    mConnectThread.cancel();
                }else {}
                if (mConnectedThread!=null)
                {
                    mConnectedThread.cancel();
                }else {}
                // TODO: 2017/3/8 ----------------取消蓝牙连接------------------
                /*
                跳转至第二个界面
                 */
                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)  //将当前fragment加入到返回栈中
                        .replace(R.id.fl_container, new LoginFragment()).commit();
//                getFragmentManager()
//                        .beginTransaction()
//                        .addToBackStack(null)  //将当前fragment加入到返回栈中
//                        .replace(R.id.fl_container, new MainFragment()).commit();
                break;
            case 2:
                //匹配失败，继续发送
                Toast.makeText(getActivity(), "分配失败,该导游机没有被借出", Toast.LENGTH_SHORT).show();
                break;
            default:
//                Toast.makeText(getActivity(), "分配失败,该导游机没有被借出", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onClick(View view) {
        cursor = database.query(true, "fenpei", new String[]{"_id", "deviceid", "username", "password", "phone", "tourists", "key"}, null, null, null, null, null, null, null);
        if (cursor.getCount() == 0) {
            cursor1 = database.query(true, "daoyoujiid", new String[]{"_id", "deviceid"}, null, null, null, null, null, null, null);
            while (cursor1.moveToNext()) {
                id = cursor1.getString(1);
            }
            // 然后发送给子线程Handler
            Message msg = new Message();
            msg.what = 0x345;
            msg.obj = "Command:Checkin\r\n" + "DeviceID:" + id + "\r\n" + "Time:" + GETTime.curtime() + "\r\n";
            //========================================================================================
            handler1 = new MyHandler1();
            clientThread = new ClientThread(handler1);
            // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
            divThread = new Thread(clientThread);
            divThread.start();
            if (clientThread.revHandler!=null){
                clientThread.revHandler.sendMessage(msg);
            }
            //========================================================================================

        } else {
            // TODO: 2016/12/27 怎么关闭
            clientThread.colseall();
            getFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)  //将当前fragment加入到返回栈中
                    .replace(R.id.fl_container, new LoginFragment()).commit();
//            getFragmentManager()
//                    .beginTransaction()
//                    .addToBackStack(null)  //将当前fragment加入到返回栈中
//                    .replace(R.id.fl_container, new MainFragment()).commit();
        }
    }
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        handler1.removeCallbacksAndMessages(divThread);
//    }
}
