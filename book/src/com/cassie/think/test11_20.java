package com.cassie.think;

/**
 * Created by cassie on 2017/5/16.
 */
public class test11_20 {
    public static void main(String [] args){
        Integer [] list1 = {12,24,55,1};
        Double [] list2 = {12.4,24.0,55.2,1.0};
        int[] list3 = {1,2,3};
        printArray(list1);
        printArray(list2);
//        printArray(list3);
    }
    public static void printArray(Object [] list){
        for(Object o : list){
            System.out.print(o + " ");
        }
        System.out.println();

    }
}
