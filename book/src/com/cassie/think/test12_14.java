package com.cassie.think;

/**
 * Created by cassie on 2017/5/15.
 */
public class test12_14 {
    public static void main(String [] args){
        try{
            int [] list = new int[10];
            System.out.println("list[10] is " + list[10]);
        }catch (ArithmeticException ex){
            System.out.println("A");
        }catch (RuntimeException ex){
            System.out.println("R");
        }catch (Exception ex){
            System.out.println("E");
        }

    }

}
