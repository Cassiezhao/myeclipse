package com.example.login1.fragment;


import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login1.API.myapi;
import com.example.login1.R;
import com.example.login1.database.MySQLiteOpenHelper;
import com.example.login1.http.AsyncHttpClient;
import com.example.login1.http.AsyncHttpResponseHandler;
import com.example.login1.http.RequestParams;
import com.example.login1.utils.ClientThread;
import com.example.login1.utils.GETTime;
import com.xaccp.library.util.ToastUtils;

import org.apache.http.Header;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 */
//CompoundButton.OnCheckedChangeListener
public class LoginFragment extends Fragment implements View.OnClickListener {
    // TODO: 2017/3/6--------------------------------------------------
    private static final String TAG = "LoginFragment";
    private ConnectThread mConnectThread=null;
    public ConnectedThread mConnectedThread;

    private BluetoothAdapter bluetoothAdapter;
    private final UUID MY_UUID = UUID.fromString(myapi.uuid);
    private BluetoothDevice device;
    // TODO: 2017/3/6--------------------------------------------------


    private EditText userName, password;
    private String userNameValue,passwordValue,did,result,message1,
            userNameValue1=null,passwordValue1=null,PhoneValue1=null,TouristsValue1=null,keyvalue1=null,
            userNameValue11=null,passwordValue11=null,PhoneValue11=null,keyvalue11=null,TouristsValue11=null,
            pingjiaValue11,timeValue11,userNameValue111,message=null;
//    private CheckBox remPwd;
    private Button lgBtn;
    SharedPreferences sp;
    private boolean mmflag=true,stopchuankou=false;
    Handler handlerid,handler2;
    MySQLiteOpenHelper openHelper;
    SQLiteDatabase database;
    Cursor cursor;
    ContentValues values;
    // 定义与服务器通信的子线程
    ClientThread clientThread;
    private int i;
    Thread loginThread;
    private SurfaceView mySurfaceView;
    private SurfaceHolder myHolder;
    private Camera myCamera;

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
                handler2 = new MyHandler2();
                clientThread = new ClientThread(handler2);
                // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
                loginThread = new Thread(clientThread);
                loginThread.start();
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
    //==================================上传文件================================
    public void upload() {
        try {
            // 得到用户的文件路径
            String path = "/sdcard/pic/"+userNameValue11+".jpg";
            File file = new File(path);

            // 访问网络上传文件
            AsyncHttpClient client = new AsyncHttpClient();

            RequestParams params = new RequestParams();
            params.put("ppt", file);
            client.post(myapi.UP_URL, params, new AsyncHttpResponseHandler() {

                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    ToastUtils.toast("上传成功");
                }

                @Override
                public void onFailure(int statusCode, Header[] headers,
                                      byte[] responseBody, Throwable error) {
                    error.printStackTrace();
                    ToastUtils.toast("上传失败");
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //==================================上传文件=======================================

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_login, container, false);
        //=====================================================================
        intentFilter = new IntentFilter();
        //addAction
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceive = new NetworkChangeReceive();
        getActivity().registerReceiver(networkChangeReceive, intentFilter);
        //=====================================================================
        handler2 = new MyHandler2();
        clientThread = new ClientThread(handler2);
        // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
        loginThread = new Thread(clientThread);
        loginThread.start();
        //初始化surface
        //初始化surfaceview
        mySurfaceView = (SurfaceView) view.findViewById(R.id.camera_surfaceview);
        initSurface();
        // TODO: 2017/3/6--------------------------------------------------
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        device = bluetoothAdapter.getRemoteDevice(myapi.btadress);
        connect(device);
        // TODO: 2017/3/6--------------------------------------------------
        initView(view);
        hislocation();
        return view;
    }

    private void hislocation() {
        StringBuffer sb = new StringBuffer();
        cursor = database.query(true, "jingwei", new String[] {"_id","deviceid","username","longitude","latitude","BTPos","time"}, null, null, null, null, null, null, null);
        while (cursor.moveToNext()){
            String jindu = cursor.getString(3);
            String weidu = cursor.getString(4);
            String BTPos = cursor.getString(5);
            String time = cursor.getString(6);
            sb.append(weidu+","+jindu+","+BTPos+","+time+";");
        }
        String HisPos = sb.toString();
        message = "Command:HisPos\r\n" + "DeviceID:" + did + "\r\n" + "Pos:" + HisPos + "\r\n";
        // 然后发送给子线程Handler
        Message msg = new Message();
        msg.what = 0x345;
        msg.obj = message;
        //========================================================================================
        handler2 = new MyHandler2();
        clientThread = new ClientThread(handler2);
        // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
        loginThread = new Thread(clientThread);
        loginThread.start();
        if (clientThread.revHandler != null) {
            clientThread.revHandler.sendMessage(msg);
        }
        //=========================================================================================

    }

    private void initView(View view) {
        handlerid= new Handler();
        openHelper=new MySQLiteOpenHelper(getActivity(),1);
        database=openHelper.getWritableDatabase();
//        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        handler2 = new MyHandler2();
        clientThread = new ClientThread(handler2);
        // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
        loginThread = new Thread(clientThread);
        loginThread.start();
        //创建数据库对象,并不会创建数据库
        //创建数据库
        cursor = database.query(true, "fenpei", new String[] {"_id","deviceid","username","password","phone","tourists","key"}, null, null, null, null, null, null, null);


        while (cursor.moveToNext()) {
            did= cursor.getString(1);
            userNameValue11 = cursor.getString(2);
            passwordValue11 = cursor.getString(3);
            PhoneValue11 = cursor.getString(4);
            TouristsValue11 = cursor.getString(5);
            keyvalue11 = cursor.getString(6);
        }
        handlerid.postDelayed(mTimeTaskid, 15000);
        //获得实例对象
        sp = getActivity().getSharedPreferences("userInfo", Context.MODE_WORLD_READABLE);
        userName = (EditText) view.findViewById(R.id.username_edit2);
//        userName.append(userNameValue11);
        password = (EditText) view.findViewById(R.id.password_edit2);
        lgBtn = (Button)view.findViewById(R.id.logbtn2);
        lgBtn.setOnClickListener(this);
        // TODO: 2016/12/29
//        remPwd = (CheckBox)view.findViewById(R.id.checkBox2);
//        remPwd.setOnCheckedChangeListener(this);
        //判断记住密码多选框的状态
//        if(sp.getBoolean("ISCHECK", false))
//        {
//            remPwd.setChecked(true);
//            userName.setText(sp.getString("USER_NAME", ""));
//            password.setText(sp.getString("PASSWORD", ""));
//        }

    }
    private Runnable mTimeTaskid=new Runnable() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            // 然后发送给子线程Handler=================================================================
            Message msg = new Message();
            msg.what = 0x345;
            msg.obj = "Command:Checkin2\r\n"+"DeviceID:"+did+"\r\n"+"Time:"+ GETTime.curtime()+"\r\n";
            //========================================================================================
            handler2 = new MyHandler2();
            clientThread = new ClientThread(handler2);
            // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
            loginThread = new Thread(clientThread);
            loginThread.start();
            if (clientThread.revHandler!=null){
                clientThread.revHandler.sendMessage(msg);
            }
            //=========================================================================================

            //=========================================================================================

            handlerid.postDelayed(this, 15000);
        }
    };

    /**
     * 复选框变化
     */
    // TODO: 2016/12/29
//    @Override
//    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        if (remPwd.isChecked()) {
//            Toast.makeText(getActivity(), "已记住密码", Toast.LENGTH_SHORT).show();
//            sp.edit().putBoolean("ISCHECK", true).commit();
//        }else {
//            Toast.makeText(getActivity(), "未记住密码", Toast.LENGTH_SHORT).show();
//            sp.edit().putBoolean("ISCHECK", false).commit();
//        }
//    }
    /*
        登陆
     */
    @Override
    public void onClick(View view) {
        //创建数据库
        cursor = database.query(true, "fenpei", new String[] {"_id","deviceid","username","password","phone","tourists","key"}, null, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            userNameValue11 = cursor.getString(2);
            passwordValue11 = cursor.getString(3);
            PhoneValue11 = cursor.getString(4);
            TouristsValue11 = cursor.getString(5);
            keyvalue11 = cursor.getString(6);
        }
        /*
         try {
         passwordValue = MD5Util.md5Encode(password.getText().toString());
         } catch (Exception e) {
         e.printStackTrace();
         }
         */
        // TODO: 2016/12/16 还未加密
        userNameValue = userName.getText().toString();
        passwordValue = password.getText().toString();
        //判断用户名和密码是否正确
        if(userNameValue.equals(userNameValue11) && passwordValue.equals(passwordValue11))
        {
            Toast.makeText(getActivity(), "登陆成功", Toast.LENGTH_SHORT).show();
            // 然后发送给子线程Handler=================================================================
            Message msg = new Message();
            msg.what = 0x345;
            msg.obj = "Command:shangxian\r\n"+"DeviceID:"+did+"\r\n"+"PhotoName:"+userNameValue11+".jpg"+"\r\n"+"Time:"+ GETTime.curtime()+"\r\n";
            //========================================================================================
            handler2 = new MyHandler2();
            clientThread = new ClientThread(handler2);
            // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
            loginThread = new Thread(clientThread);
            loginThread.start();
            if (clientThread.revHandler!=null){
                clientThread.revHandler.sendMessage(msg);
            }
            //=========================================================================================
// TODO: 2016/12/29
//            if(remPwd.isChecked())
//            {
//                //记住用户名、密码
//                SharedPreferences.Editor editor = sp.edit();
//                editor.putString("USER_NAME", userNameValue);
//                editor.putString("PASSWORD",passwordValue);
//                editor.commit();
//            }
//// TODO: 2016/12/19 先注释 好操作
//            //发送导游机开机命令
            // TODO: 2017/3/8 ------------------蓝牙发送消息-----------------
            if(mConnectedThread !=null){
                mConnectedThread.write("login\r\n");
            }else {}
            // TODO: 2017/3/8 ------------------蓝牙发送消息-----------------
            //初始化camera并对焦拍照
            initCamera();
            //  跳转至5能界面
//            //===========================================
//            clientThread.colseall();
//            setchuankou();
//            handlerid.removeCallbacksAndMessages(null);
//            handler2.removeCallbacksAndMessages(null);
////            loginThread.interrupt();
////            loginThread=null;
//            //===========================================
//
//            getFragmentManager()
//                    .beginTransaction()
//                    .addToBackStack(null)  //将当前fragment加入到返回栈中
//                    .replace(R.id.fl_container, new MainFragment()).commit();

        }
        else
        {
            Toast.makeText(getActivity(),"用户名或密码错误，请重新登录", Toast.LENGTH_LONG).show();
        }
    }

    class MyHandler2 extends Handler {
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
    //一个判断的方法
    public void judgement(String msg){
        values=new ContentValues();
        //创建数据库
        SQLiteDatabase database=openHelper.getWritableDatabase();
        String regex = ".*ReturnSuccess\\r?\\n?.*";
        String regex1 = ".*Command:(Agree2)\\r?\\n?.*Username:(.*)\\r?\\n?.*Userpassword:(.*)\\r?\\n?.*ServerPhone:(.*)\\r?\\n?.*Tourists:(.*)\\r?\\n?.*key:(.*)\\r?\\n?.*";
        String regex2 = ".*Command:(Deny)\\r?\\n?.*";
        String regex3 = ".*UpdateSuccess\\r?\\n?.*";
        String regex4 = ".*Command:shangxianok\\r?\\n?.*";
        String regex5 = ".*Command:GotPos\\r?\\n?.*";
        if (msg==null) {
            Log.d("还没有", "接收到数据");
        }else if (msg.matches(regex1)==true) {
            //重新分配成功
            userNameValue111 = msg.replaceAll(regex1, "$2");
            if(userNameValue111!=userNameValue11){
                //匹配成功，把用户名和密码存一个变量
                userNameValue1 = msg.replaceAll(regex1, "$2");
                passwordValue1 = msg.replaceAll(regex1, "$3");
                PhoneValue1 = msg.replaceAll(regex1, "$4");
                TouristsValue1 = msg.replaceAll(regex1, "$5");
                keyvalue1 = msg.replaceAll(regex1, "$6");
                //上传评价信息一类的
                sendinfo2();
//                try {
//                    Thread.currentThread().sleep(15000);//阻断15秒
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }

        }else if (msg.matches(regex2)==true) {
                //表明导游机没有被借出 应该Return 上传信息
                sendinfo();
//                try {
//                    Thread.currentThread().sleep(15000);//阻断15秒
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
       }else if (msg.matches(regex3)==true) {
            //上传成功删除数据库
            dbdelete();
            //也要发送resetgroupid
            // TODO: 2017/3/8 ------------------蓝牙发送消息-----------------
            if(mConnectedThread !=null){
                mConnectedThread.write("resetgroupid\r\n");
            }else {}
            // TODO: 2017/3/8 ------------------蓝牙发送消息-----------------
            //更新分配信息 写入数据库
            values.put("deviceid", did);
            values.put("username", userNameValue1);
            values.put("password", passwordValue1);
            values.put("phone", PhoneValue1);
            values.put("tourists", TouristsValue1);
            values.put("key", keyvalue1);
            database.insert("fenpei",null,values);
            Toast.makeText(getActivity(), "重新分配成功", Toast.LENGTH_SHORT).show();

        }else if (msg.matches(regex)==true) {
            //上传成功删除数据库
            dbdelete();
            //也要发送resetgroupid
            // TODO: 2017/3/8 ------------------蓝牙发送消息-----------------
            if(mConnectedThread !=null){
                mConnectedThread.write("resetgroupid\r\n");
            }else {}
            // TODO: 2017/3/8 ------------------蓝牙发送消息-----------------
            //===========================================
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
            handlerid.removeCallbacksAndMessages(null);
            handler2.removeCallbacksAndMessages(null);
//            loginThread.interrupt();
//            loginThread=null;
            //===========================================
            getFragmentManager().popBackStack();
            Toast.makeText(getActivity(), "分配失败,该导游机没有被借出", Toast.LENGTH_SHORT).show();
        }else if (msg.matches(regex4)==true){
            // TODO: 2016/12/19 先注释 好操作
            //发送导游机开机命令
            // TODO: 2017/3/8 ------------------蓝牙发送消息-----------------
            if(mConnectedThread !=null){
                mConnectedThread.write("login\r\n");
            }else {}
            // TODO: 2017/3/8 ------------------蓝牙发送消息-----------------
            //  跳转至5能界面
            //===========================================
            clientThread.colseall();
            handlerid.removeCallbacksAndMessages(null);
            handler2.removeCallbacksAndMessages(null);
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
//            loginThread.interrupt();
//            loginThread=null;
            //===========================================

            getFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)  //将当前fragment加入到返回栈中
                    .replace(R.id.fl_container, new MainFragment()).commit();
        }else if (msg.matches(regex5)==true){
            locdelete();
        }else{
            Log.e("登录界面","没有匹配命令");
        }
    }
    public void sendinfo() {

        //创建数据库

        cursor = database.query(true, "pingjia", new String[] {"_id","username","tourists","pingjiaxinxi","time"}, null, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            userNameValue11 = cursor.getString(1);
            pingjiaValue11 = cursor.getString(3);
            timeValue11 = cursor.getString(4);
        }
        //传输导游机编号认证，获取相应的用户名和密码的md5值
        message1 = "Command:Return\r\n"+"DeviceID:"+did+"\r\n"+"Username:"+userNameValue11+"\r\n"+"Time:"+GETTime.curtime()+"\r\n"+"Evaluation:"+pingjiaValue11+"\r\n";
        Message msg = new Message();
        msg.what = 0x345;
        msg.obj = message1;
        //========================================================================================
        handler2 = new MyHandler2();
        clientThread = new ClientThread(handler2);
        // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
        loginThread = new Thread(clientThread);
        loginThread.start();
        if (clientThread.revHandler!=null){
            clientThread.revHandler.sendMessage(msg);
        }
        //=========================================================================================
    }
    public void sendinfo2() {

        //创建数据库

        cursor = database.query(true, "pingjia", new String[] {"_id","username","tourists","pingjiaxinxi","time"}, null, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            userNameValue11 = cursor.getString(1);
            pingjiaValue11 = cursor.getString(3);
            timeValue11 = cursor.getString(4);
        }
        //传输导游机编号认证，获取相应的用户名和密码的md5值
        // 然后发送给子线程Handler
        message1 = "Command:Return2\r\n"+"DeviceID:"+did+"\r\n"+"Username:"+userNameValue11+"\r\n"+"Time:"+GETTime.curtime()+"\r\n"+"Evaluation:"+pingjiaValue11+"\r\n";
        Message msg = new Message();
        msg.what = 0x345;
        msg.obj = message1;
        //========================================================================================
        handler2 = new MyHandler2();
        clientThread = new ClientThread(handler2);
        // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
        loginThread = new Thread(clientThread);
        loginThread.start();
        if (clientThread.revHandler!=null){
            clientThread.revHandler.sendMessage(msg);
        }
        //=========================================================================================

    }

    //清空数据库
    public void dbdelete() {

        database.delete("fenpei", null, null);
        database.delete("xiaoxi", null, null);
        database.delete("pingjia", null, null);
        database.delete("jingwei", null, null);
        database.delete("yuyinxiaoxi",null,null);
        database.delete("tourists",null,null);
    }

    public void locdelete(){
        database.delete("jingwei",null,null);
    }

    private Handler bthandler=new Handler(){
        public void handleMessage(Message msg) {
            //获取数据
            String dataString =(String) msg.obj;
            String mark ="\r\n";
            String[] strings = dataString.split(mark);//格式// ;
//            ToastUtils.toast("登录界面的"+dataString);
            Log.e("bluetooth2",dataString);
            // TODO: 2016/12/16 判断一下接收的什么数据
            if (strings[0].equalsIgnoreCase("PASS")){
                Log.e("清楚", "板子信息");
            }else  if (strings[0].equalsIgnoreCase("ENTER")){
                Log.e("开启", "导游机");
                //ToastUtils.toast("你好你好");
                //=====================================
                clientThread.colseall();
                handlerid.removeCallbacksAndMessages(null);
                handler2.removeCallbacksAndMessages(null);
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
//                loginThread.interrupt();
//                loginThread=null;
                //=====================================
                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)  //将当前fragment加入到返回栈中
                        .replace(R.id.fl_container, new MainFragment()).commit();
            }else{

            }

        }
    };

    //=================================照相===========================================
    //初始化surface
    @SuppressWarnings("deprecation")
    private void initSurface()
    {
        //初始化surfaceholder
        myHolder = mySurfaceView.getHolder();
        myHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

    }
    //初始化摄像头
    private void initCamera() {

        //如果存在摄像头
        if(checkCameraHardware(getActivity()))
        {
            //获取摄像头（首选前置，无前置选后置）
            if(openFacingFrontCamera())
            {
                Log.d("Demo", "openCameraSuccess");
                //进行对焦
                autoFocus();
            }
            else {
                Log.d("Demo", "openCameraFailed");
            }

        }
    }

    //对焦并拍照
    private void autoFocus() {

        try {
            //因为开启摄像头需要时间，这里让线程睡两秒
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //自动对焦
        myCamera.autoFocus(myAutoFocus);
        myCamera.enableShutterSound(true);
        //对焦后拍照
        myCamera.takePicture(null, null, myPicCallback);
    }



    //判断是否存在摄像头
    private boolean checkCameraHardware(Context context) {

        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // 设备存在摄像头
            return true;
        } else {
            // 设备不存在摄像头
            return false;
        }

    }

    //得到摄像头
    private boolean openFacingFrontCamera() {

        //尝试开启前置摄像头
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int camIdx = 0, cameraCount = Camera.getNumberOfCameras(); camIdx < cameraCount; camIdx++) {
            Camera.getCameraInfo(camIdx, cameraInfo);
            if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                try {
                    Log.d("Demo", "tryToOpenCamera");
                    myCamera = Camera.open(camIdx);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }

        //如果开启前置失败（无前置）则开启后置
        if (myCamera == null) {
            for (int camIdx = 0, cameraCount = Camera.getNumberOfCameras(); camIdx < cameraCount; camIdx++) {
                Camera.getCameraInfo(camIdx, cameraInfo);
                if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_BACK) {
                    try {
                        myCamera = Camera.open(camIdx);
                    } catch (RuntimeException e) {
                        return false;
                    }
                }
            }
        }

        try {
            //这里的myCamera为已经初始化的Camera对象
            myCamera.setPreviewDisplay(myHolder);
        } catch (IOException e) {
            e.printStackTrace();
            myCamera.stopPreview();
            myCamera.release();
            myCamera = null;
        }

        myCamera.startPreview();

        return true;
    }

    //自动对焦回调函数(空实现)
    private Camera.AutoFocusCallback myAutoFocus = new Camera.AutoFocusCallback() {
        @Override
        public void onAutoFocus(boolean success, Camera camera) {
        }
    };

    //拍照成功回调函数
    private Camera.PictureCallback myPicCallback = new Camera.PictureCallback() {

        @SuppressLint("SdCardPath")
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            //将得到的照片进行270°旋转，使其竖直
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 8;
//            Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length,options);
//            Matrix matrix = new Matrix();
//            matrix.preRotate(270);
//            bitmap = Bitmap.createBitmap(bitmap ,0,0, bitmap .getWidth(), bitmap .getHeight(),matrix,true);

            //创建并保存图片文件
            //	File pictureFile = new File(getDir(), "camera.jpg");

//            String name = DateFormat.format("", Calendar.getInstance(Locale.CHINA))+ ".jpg";
            String name = userNameValue11+ ".jpg";
            File file = new File("/sdcard/pic/");
            file.mkdirs(); //创建文件夹保存照片
            String filename=file.getPath()+File.separator+name;
            Bitmap bitmap1 = BitmapFactory.decodeByteArray(data, 0, data.length,options);
            try {
                FileOutputStream fos = new FileOutputStream(filename);
                boolean b=bitmap1.compress(Bitmap.CompressFormat.PNG, 100, fos);
                fos.flush();
                fos.close();
                if (b) {
                    ToastUtils.toast("照片储存成功");
                }else {
                    ToastUtils.toast("照片储存失败");
                }
            } catch (Exception error) {
                ToastUtils.toast("拍照失败");
                Log.d("Demo", "保存照片失败" + error.toString());
                error.printStackTrace();
                myCamera.stopPreview();
                myCamera.release();
                myCamera = null;
            }
            //Log.d("Demo", "获取照片成功");
            //Toast.makeText(.this, "获取照片成功", Toast.LENGTH_SHORT).show();;
            myCamera.stopPreview();
            myCamera.release();
            myCamera = null;
            //完成拍照后关闭相关东西
            //===========================================================
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
            handlerid.removeCallbacksAndMessages(null);
            handler2.removeCallbacksAndMessages(null);
            upload();
            getFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)  //将当前fragment加入到返回栈中
                    .replace(R.id.fl_container, new MainFragment()).commit();
            //============================================================
        }
    };
    //=================================照相===========================================


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
        private  final BluetoothSocket mmSocket;
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
                mmSocket.close();
            } catch (IOException e) {
                Log.e(TAG, "close() of connect socket failed", e);
            }
        }
    }

    // TODO: 2017/3/7 ---------------------------------------------------------


//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        handlerid.removeCallbacksAndMessages(mTimeTaskid);
//        handler2.removeCallbacksAndMessages(loginThread);
//    }
}
