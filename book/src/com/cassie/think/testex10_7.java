package com.cassie.think;

/**
 * Created by cassie on 2017/5/16.
 */
public class testex10_7 {
    public static void main(String [] args){
        ex10_7 stack = new ex10_7();
        for(int i = 0; i < 10; i++){
            stack.push(i);
        }
        while(! stack.empty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
