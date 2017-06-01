package com.example.login1.app;

import android.app.Application;

import com.xaccp.library.util.AppHolder;

/**
 * Created by Administrator on 2016/11/25.
 *
 * 一定要注册  manifest  文件
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化
        AppHolder.init(getApplicationContext());
    }
}
