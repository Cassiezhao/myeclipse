package com.example.login1.http;

import com.example.login1.API.myapi;
import com.xaccp.library.util.ToastUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;

import java.io.File;

import okhttp3.Call;

/**
 * Created by hammer on 2016/12/20.
 */

public class fileMavHttp {
    public  void filefind(String filename){
        RequestCall build =  OkHttpUtils.get().url(myapi.MY_URL)
                .addParams("filename",filename)
                .build();
        build.execute(new FileCallBack("/sdcard/yuyinxiaoxi",filename) {
            @Override
            public void onError(Call call, Exception e, int i) {
               e.getStackTrace();
            }

            @Override
            public void onResponse(File file, int i) {
                ToastUtils.toast(file.getName());
            }

        });
    }
}
