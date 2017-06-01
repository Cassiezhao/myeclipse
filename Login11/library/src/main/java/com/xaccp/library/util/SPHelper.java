package com.xaccp.library.util;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Created by tao.zeng on 2016/9/3.
 * <p/>
 * data/data/包名/shared_pre
 */
public class SPHelper {

    private static final String SP_NAME = "share_data";
    private volatile static SharedPreferences mSP;

    private SPHelper() {
    }


    private static SharedPreferences getSharePreferences() {
        if (mSP == null) {
            synchronized (SP_NAME) {
                if (mSP == null) {
                    mSP = AppHolder.getContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
                }
            }
        }
        return mSP;
    }

    // =============================================================
    // ------------------------保存数据--------------------------------
    // ------------------ key===>键名 value===>保存的数据值 ----------------
    // =============================================================

    /**
     * 保存数据 根据数据类型自动拆箱
     *
     * @param key 键名
     * @param obj Object类型数据 但仅限于(String/int/float/boolean/long)
     */
    public static void save(String key, Object obj) {
        Editor editor = getSharePreferences().edit();
        if (obj instanceof String)
            editor.putString(key, (String) obj);

        else if (obj instanceof Integer)
            editor.putInt(key, (Integer) obj);

        else if (obj instanceof Long)
            editor.putLong(key, (Long) obj);

        else if (obj instanceof Boolean)
            editor.putBoolean(key, (Boolean) obj);

        else if (obj instanceof Float)
            editor.putFloat(key, (Float) obj);

        editor.commit();
    }

    // =============================================================
    // ------------------------获取数据--------------------------------
    // ------ key===>键名 defaultValue===>根据key查找不到的默认数据的数据值 -------
    // =============================================================

    /**
     * 获取Object类型数据 根据接收类型自动拆箱
     *
     * @param key          键名
     * @param defaultValue 根据key获取不到是默认值仅限于(String/int/float/boolean/long)
     */
    public static Object get(String key, Object defaultValue) {
        SharedPreferences sp = getSharePreferences();
        if (defaultValue instanceof String)
            return sp.getString(key, (String) defaultValue);

        else if (defaultValue instanceof Integer)
            return sp.getInt(key, (Integer) defaultValue);

        else if (defaultValue instanceof Long)
            return sp.getLong(key, (Long) defaultValue);

        else if (defaultValue instanceof Boolean)
            return sp.getBoolean(key, (Boolean) defaultValue);

        else if (defaultValue instanceof Float)
            return sp.getFloat(key, (Float) defaultValue);

        return null;
    }


    /**
     * 根据key删除数据
     *
     * @param key
     * @return
     */
    public static boolean remove(String key) {
        return getSharePreferences().edit().remove(key).commit();
    }
}
