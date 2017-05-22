package com.cassie.think;

/**
 * Created by cassie on 2017/5/15.
 */
public class test12_15 {
    public static void main(String [] args){
        try{
            method();
            System.out.println("After the method call");
        }catch (ArithmeticException ex){
            System.out.println("A");
        }catch (RuntimeException ex){
            System.out.println("R");
        }catch (Exception ex){
            System.out.println("E");
        }

    }
    static void method() throws Exception{
        System.out.println(1 / 0);
    }
}
