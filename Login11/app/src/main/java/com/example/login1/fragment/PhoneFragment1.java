package com.example.login1.fragment;

/**
 * Created by hammer on 2017/2/9.
 */
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login1.API.myapi;
import com.example.login1.R;
import com.example.login1.database.MySQLiteOpenHelper;
import com.example.login1.http.AsyncHttpClient;
import com.example.login1.http.AsyncHttpResponseHandler;
import com.example.login1.http.RequestParams;
import com.example.login1.utils.AudioRecoderUtils;
import com.example.login1.utils.PopupWindowFactory;
import com.example.login1.utils.TimeUtils;
import com.xaccp.library.util.ToastUtils;

import org.apache.http.Header;

import java.io.File;

public class PhoneFragment1 extends Fragment {
    MySQLiteOpenHelper openHelper;
    SQLiteDatabase database;
    Cursor cursor;
    private Button mButton,mButton1,fanhui1;
    private ImageView mImageView;
    private TextView mTextView;
    private AudioRecoderUtils mAudioRecoderUtils;
    private String Phone,userNameValue;

    public PhoneFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_phone1, container, false);
        final RelativeLayout rl = (RelativeLayout)view.findViewById(R.id.rl);

        //得到后台电话
        openHelper = new MySQLiteOpenHelper(getActivity(), 1);
        database = openHelper.getWritableDatabase();
        cursor = database.query(true, "fenpei", new String[]{"_id", "deviceid", "username", "password", "phone", "tourists", "key"}, null, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            userNameValue = cursor.getString(2);
            Phone = cursor.getString(4);
        }

        mButton = (Button)view.findViewById(R.id.button);
        mButton1 = (Button)view.findViewById(R.id.button1);
        fanhui1 = (Button)view.findViewById(R.id.button2);
        //PopupWindow的布局文件
        final View view1 = View.inflate(getActivity(), R.layout.layout_microphone, null);

        final PopupWindowFactory mPop = new PopupWindowFactory(getActivity(),view1);

        //PopupWindow布局文件里面的控件
        mImageView = (ImageView) view1.findViewById(R.id.iv_recording_icon);
        mTextView = (TextView) view1.findViewById(R.id.tv_recording_time);

        mAudioRecoderUtils = new AudioRecoderUtils();

        //录音回调
        mAudioRecoderUtils.setOnAudioStatusUpdateListener(new AudioRecoderUtils.OnAudioStatusUpdateListener() {

            //录音中....db为声音分贝，time为录音时长
            @Override
            public void onUpdate(double db, long time) {
                mImageView.getDrawable().setLevel((int) (3000 + 6000 * db / 100));
                mTextView.setText(TimeUtils.long2String(time));
            }

            //录音结束，filePath为保存路径
            @Override
            public void onStop(String filePath) {
                Toast.makeText(getActivity(), "录音保存在：" + filePath, Toast.LENGTH_SHORT).show();
                mTextView.setText(TimeUtils.long2String(0));
            }
        });

        //Button1的监听
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + Phone));
                startActivity(intent);
            }
        });

        //Button2的监听
        fanhui1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });

        //Button的touch监听
        mButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){

                    case MotionEvent.ACTION_DOWN:

                        mPop.showAtLocation(rl,Gravity.CENTER,0,0);
                        mButton.setText("松开保存");
                        mAudioRecoderUtils.startRecord(userNameValue);
                        break;

                    case MotionEvent.ACTION_UP:

                        mAudioRecoderUtils.stopRecord();        //结束录音（保存录音文件）
//                        mAudioRecoderUtils.cancelRecord();    //取消录音（不保存录音文件）
                        mPop.dismiss();
                        upload();
                        mButton.setText("按住说话");
                        break;
                }
                return true;
            }
        });
        return view;
    }
    //==================================上传文件================================
    public void upload() {
        try {
            // 得到用户的文件路径
            String path = "/sdcard/record/"+userNameValue+".amr";
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

}
