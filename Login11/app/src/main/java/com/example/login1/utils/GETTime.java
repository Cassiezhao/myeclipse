package com.example.login1.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class GETTime {
    public static String curtime(){
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        return str;
    }

}
