package com.xaccp.library.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by tao.zeng on 2016/9/3.
 */
public final class Log {

    private final static boolean IS_DEBUG = AppHolder.IS_DEBUG;

    private Log() {
    }

    public static void v(String msg) {
        if (IS_DEBUG)
            v(getTag(), msg);
    }

    public static void v(String tag, String msg) {
        if (IS_DEBUG)
            android.util.Log.v(tag, msg);
    }

    public static void i(String msg) {
        if (IS_DEBUG)
            i(getTag(), msg);
    }

    public static void i(String tag, String msg) {
        if (IS_DEBUG)
            android.util.Log.i(tag, msg);
    }

    public static void d(String msg) {
        if (IS_DEBUG)
            d(getTag(), msg);
    }

    public static void d(String tag, String msg) {
        if (IS_DEBUG)
            android.util.Log.d(tag, msg);
    }

    public static void w(String msg) {
        if (IS_DEBUG)
            w(getTag(), msg);
    }

    public static void w(String tag, String msg) {
        if (IS_DEBUG)
            android.util.Log.w(tag, msg);
    }

    public static void e(String msg) {
        if (IS_DEBUG)
            e(getTag(), msg);
    }

    public static void e(String tag, String msg) {
        if (IS_DEBUG)
            android.util.Log.e(tag, msg);
    }


    private static String getTag() {
        StackTraceElement[] trace = new Throwable().fillInStackTrace()
                .getStackTrace();
        String callingClass = "";
        for (int i = 2; i < trace.length; i++) {
            Class<?> clazz = trace[i].getClass();
            if (!clazz.equals(android.util.Log.class)) {
                callingClass = trace[i].getClassName();
                callingClass = callingClass.substring(callingClass
                        .lastIndexOf('.') + 1);
                break;
            }
        }
        return callingClass;
    }

    public static void write2Log(String msg) {
        if (IS_DEBUG)
            write2Log(msg, new StringBuffer((int) System.currentTimeMillis()).append("_log").toString());
    }

    public static void write2Log(String msg, String name) {
        if (IS_DEBUG) {
            File logFile = new File(AppHolder.getContext().getExternalCacheDir().getPath(), name + ".txt");
            BufferedWriter writer = null;
            try {
                logFile.createNewFile();
                writer = new BufferedWriter(new FileWriter(logFile, true));
                writer.newLine();
                writer.append(msg);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                IoUtils.closeIO(writer);
            }
        }
    }
}
