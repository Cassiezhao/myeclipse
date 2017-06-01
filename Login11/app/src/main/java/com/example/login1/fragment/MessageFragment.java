package com.example.login1.fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login1.API.myapi;
import com.example.login1.R;
import com.example.login1.database.MySQLiteOpenHelper;
import com.xaccp.library.util.ToastUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment  {
    private TextView sender;
    private TextView content;
//    private Button xiaoxi,xxpause,xxstop,xxtest;
    MediaPlayer mp ;
    MySQLiteOpenHelper openHelper;
    SQLiteDatabase database;
    Cursor cursor;
    SharedPreferences sharedPreferences;
    private String evmsg,filename;
    private ListView listView,listViewyuyin;
    List<String> mylist=new ArrayList<>();
    List<String> mylist1=new ArrayList<>();
    List<String> mylist2=new ArrayList<>();
    private ArrayAdapter<String> adapter,adapter2;
    int position=0;
    private Button fanhui;



    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_message, container, false);
        openHelper =new MySQLiteOpenHelper(getActivity(),1);
        database=openHelper.getWritableDatabase();
        initView(view);
        return view;
    }
    private void initView(View view){
        content = (TextView) view.findViewById(R.id.content);
        listView = (ListView)view.findViewById(R.id.udpmsg);
        listViewyuyin=(ListView)view.findViewById(R.id.yuyinxx);
        fanhui = (Button)view.findViewById(R.id.fanhui);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });


//        xiaoxi = (Button)view.findViewById(R.id.xiaoxi);
//        xxpause = (Button)view.findViewById(R.id.xxpause);
//        xxstop = (Button)view.findViewById(R.id.xxstop);
        //xxtest = (Button)view.findViewById(R.id.xxtest);
        /*
        xiaoxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    mp.setDataSource(myapi.MY_URL+"?filename="+filename);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    mp.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (!mp.isPlaying()){
                    mp.seekTo(position);
                    mp.start();
                }

                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            }
        });

        xxpause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(mp.isPlaying()){
                    position = mp.getCurrentPosition();
                    mp.pause();
                }
            }
        });
        xxstop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(mp.isPlaying()){
                    mp.stop();
                    mp.reset();
                    position = 0;
                }
            }
        });
//        xxtest.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                fileMavHttp fac=new fileMavHttp();
//                fac.filefind();
//            }
//        });
        */
        //udp传输的消息从数据库取出
        cursor = database.query(true, "xiaoxi", new String[] {"_id","deviceid","messagesid","messages","time"}, null, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            evmsg = cursor.getString(3);
            Log.e("messagesjiemian", evmsg);
            mylist.add(evmsg);
        }
        //===============================================================================
        cursor = database.query(true, "yuyinxiaoxi", new String[] {"_id","deviceid","messagesid","messagesname","time"}, null, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            filename = cursor.getString(3);
            Log.e("messages界面", filename);
            mylist2.add(filename);
        }
        //===============================================================================
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mylist);
        adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mylist2);
        listView.setAdapter(adapter);//在列表2里面显示短消息
        listViewyuyin.setAdapter(adapter2);//在列表3里面显示语音消息

        listViewyuyin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                filename=(String)parent.getItemAtPosition(position);
                try {
                    Log.e("语音文件名",filename);
                    mp= new MediaPlayer();
					mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mp.setDataSource(myapi.MY_URL+"?filename="+filename.trim());
                    mp.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (!mp.isPlaying()){
                    mp.start();
                }
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            }
        });
    }

}

