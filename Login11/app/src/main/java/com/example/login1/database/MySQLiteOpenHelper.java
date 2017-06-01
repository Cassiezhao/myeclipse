package com.example.login1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by hell_blade on 2016/9/29.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    public MySQLiteOpenHelper(Context context, int version) {
        /**
         * context 上下文 
         * name 数据库名称
         * version 数据库版本
         * */
        super(context, "daoyouji.db", null, version);
    }

    /**
     * 数据库文件创建成功后调用，创建表
     * */

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("creatdb", "onCreate: ");
        db.execSQL("create table jingwei(_id INTEGER PRIMARY KEY AUTOINCREMENT,deviceid TEXT,username TEXT,longitude TEXT,latitude TEXT,BTPos TEXT,time TEXT)");
        db.execSQL("create table pingjia(_id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,tourists TEXT,pingjiaxinxi TEXT,pingjunxinxi,TEXT,time TEXT)");
        db.execSQL("create table fenpei(_id INTEGER PRIMARY KEY AUTOINCREMENT,deviceid TEXT,username TEXT,password TEXT,phone TEXT,tourists TEXT,key TEXT)");
        db.execSQL("create table xiaoxi(_id INTEGER PRIMARY KEY AUTOINCREMENT,deviceid TEXT,messagesid TEXT,messages TEXT,time TEXT)");
        db.execSQL("create table yuyinxiaoxi(_id INTEGER PRIMARY KEY AUTOINCREMENT,deviceid TEXT,messagesid TEXT,messagesname TEXT,time TEXT)");
        db.execSQL("create table daoyoujiid(_id INTEGER PRIMARY KEY AUTOINCREMENT,deviceid TEXT)");
        db.execSQL("create table tourists(_id INTEGER PRIMARY KEY AUTOINCREMENT,tourists TEXT)");
    }

    /**
     * 数据库文件需要更新时调用
     * */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("creatdb", "onUpgrade: ");

    }
}