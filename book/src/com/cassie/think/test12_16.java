package com.cassie.think;

/**
 * Created by cassie on 2017/5/15.
 */
public class test12_16 {
    public static void main(String [] args){
        try{
            method();
            System.out.println("After the method call");

        }catch (RuntimeException ex){
            System.out.println("R");
        }catch (Exception ex){
            System.out.println("E");
        }

    }
    static void method() throws Exception{
        try{
            String s = "abc";

            System.out.println(s.charAt(3));
        }catch (RuntimeException ex){
            System.out.println("R in method");
        }catch (Exception ex){
            System.out.println("E in method");
        }

    }
}