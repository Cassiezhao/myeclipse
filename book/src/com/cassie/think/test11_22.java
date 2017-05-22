package com.cassie.think;

/**
 * Created by cassie on 2017/5/16.
 */
public class test11_22 {
    public static void main(String [] args){
           A a = new A(3);
    }
}
class A extends B{
    public A(int i){
        System.out.println("A's constructor is invoked");
    }
}
class B{
    public B(){
        System.out.println("B's constructor is invoked");
    }
}