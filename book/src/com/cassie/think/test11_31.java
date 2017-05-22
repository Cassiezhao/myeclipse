package com.cassie.think;

import java.util.ArrayList;

/**
 * Created by cassie on 2017/5/16.
 */
public class test11_31 {
    public static void main(String [] args){
        ArrayList<String> list = new ArrayList<>();
        list.add("Denver");
        list.add("Austin");
//        list.add(new java.util.Date());
        list.set(3,"Dalas");
        System.out.println(list.get(3));
    }
}
