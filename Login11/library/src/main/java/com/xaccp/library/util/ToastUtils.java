package com.xaccp.library.util;


import android.widget.Toast;

/**
 * Created by tao.zeng on 2016/9/3.
 */
public class ToastUtils {


    public static void toast(CharSequence msg) {
        toast(msg, Toast.LENGTH_SHORT);
    }

    public static void toast(int id) {
        toast(id, Toast.LENGTH_SHORT);
    }


    public static void toast(int id, final int duration) {
        toast(AppHolder.getResource().getString(id), duration);
    }

    public static void toast(final CharSequence msg, final int duration) {
        DisplayHelper.postInUIThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(AppHolder.getContext(), msg, duration).show();
            }
        });
    }
}
