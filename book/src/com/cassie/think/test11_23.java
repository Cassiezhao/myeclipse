package com.cassie.think;

/**
 * Created by cassie on 2017/5/16.
 */
public class test11_23 {
    public static void main(String [] args){
        new A2();
        new B2();
    }
}
class A2{
    int i = 7;
    public A2(){
        setI(20);
        System.out.println("i from A is " + i);
    }
    public void setI(int i){
        this.i = 2 * i;
    }
}
class B2 extends A2{
    public B2(){
        System.out.println("i from B is " + i);
    }
    public void setI(int i){
        this.i = 3 * i;
    }
}