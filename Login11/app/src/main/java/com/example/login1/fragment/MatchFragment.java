package com.example.login1.fragment;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.login1.API.myapi;
import com.example.login1.R;
import com.example.login1.database.MySQLiteOpenHelper;
import com.xaccp.library.util.ToastUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 */
public class MatchFragment extends Fragment implements View.OnClickListener {
    // TODO: 2017/3/6--------------------------------------------------
    private static final String TAG = "MatchFragment";
    private ConnectThread mConnectThread=null;
    public ConnectedThread mConnectedThread;

    private BluetoothAdapter bluetoothAdapter;
    private final UUID MY_UUID = UUID.fromString(myapi.uuid);
    private BluetoothDevice device;
    // TODO: 2017/3/6--------------------------------------------------

    MySQLiteOpenHelper openHelper;
    SQLiteDatabase database;
    Cursor cursor;
    private TextView tv1;
    private Button ceshi,peidui;
    int a=0;
    public String tourist;

    public MatchFragment() {
        // Required empty public constructor
    }

;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_match, container, false);
        openHelper = new MySQLiteOpenHelper(getActivity(), 1);
        database = openHelper.getWritableDatabase();
        cursor = database.query(true, "fenpei", new String[]{"_id", "deviceid", "username", "password", "phone", "tourists", "key"}, null, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            tourist = cursor.getString(5);
        }
        // TODO: 2017/3/6--------------------------------------------------
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        device = bluetoothAdapter.getRemoteDevice(myapi.btadress);
        // TODO: 2017/3/6--------------------------------------------------
//        Bundle bundle = getArguments();
//        tourist =bundle.getString("tts");
        initView(view);
        return view;
    }

    // TODO: 2017/3/7 ---------------------------------------------------------
    public void connect(BluetoothDevice device) {
        Log.e(TAG, "connect to: " + device);
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

    private void initView(View view) {
        view.findViewById(R.id.tingzhi).setOnClickListener(this);
        tv1= (TextView) view.findViewById(R.id.ceshit);
        tv1.setText(tourist+"人可配对");
        view.findViewById(R.id.peidui).setOnClickListener(this);
        view.findViewById(R.id.fanhui).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tingzhi:

                if(a==0) {
                    a=1;
                    // TODO: 2017/3/8 ------------------蓝牙发送消息-----------------
                    connect(device);
                    if(mConnectedThread !=null){
                        mConnectedThread.write("exitpair\r\n");
                    }else {}
                    // TODO: 2017/3/8 ------------------蓝牙发送消息-----------------
                }

                break;
            case R.id.peidui:
                // TODO: 2017/3/8 ------------------蓝牙发送消息-----------------
                connect(device);
                if(mConnectedThread !=null){
                    mConnectedThread.write("enterpair\r\n");
                }else {}
                // TODO: 2017/3/8 ------------------蓝牙发送消息-----------------

                break;
            case R.id.fanhui:
                // TODO: 2017/3/8 ------------------蓝牙发送消息-----------------
                connect(device);
                if(mConnectedThread !=null){
                    mConnectedThread.write("login\r\n");
                }else {}
                // TODO: 2017/3/8 ------------------蓝牙发送消息-----------------
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
                getFragmentManager().popBackStack();
                break;
        }
    }
    Handler bthandler=new Handler(){
        public void handleMessage(Message msg) {
            String result =(String) msg.obj;
            String mark ="\r\n";
            String[] strings = result.split(mark);//格式
            //Toast.makeText(Matches.this, strings[0], Toast.LENGTH_SHORT).show();
            if (strings[0].equalsIgnoreCase("OK")) {
                //清除指令成功
                ToastUtils.toast("退出!");
                a=0;
                // TODO: 2017/3/8 ------------------蓝牙发送消息-----------------
                connect(device);
                if(mConnectedThread !=null){
                    mConnectedThread.write("login\r\n");
                }else {}
                // TODO: 2017/3/8 ------------------蓝牙发送消息-----------------
                //getFragmentManager().popBackStack();
                //Matches.this.finish();
            }else if (strings[0].equalsIgnoreCase("ENTER")){
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
                getFragmentManager().popBackStack();
                //Matches.this.finish();
            }else{
                tv1.setText(strings[0]+"/"+tourist+"人可配对");//这个可行
                ContentValues values = new ContentValues();
                //创建数据库
                database = openHelper.getWritableDatabase();
                values.put("tourists", strings[0]);
                database.insert("tourists", null, values);
                //Toast.makeText(Matches.this,"我进来了", Toast.LENGTH_SHORT).show();
            }

        }};

}
