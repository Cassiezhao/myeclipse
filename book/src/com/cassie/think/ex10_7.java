package com.cassie.think;

/**
 * Created by cassie on 2017/5/16.
 */
public class ex10_7 {
    private int [] elements;
    private int size;
    public static final int DEFAULT_CAPACITY = 16;

    public ex10_7(){
        this (DEFAULT_CAPACITY);
    }
    public ex10_7(int capacity){
        elements = new int[capacity];
    }
    public void push(int value){
        if (size >= elements.length){
            int [] temp = new int[elements.length * 2];
            System.arraycopy(elements,0,temp,0,elements.length);
            elements = temp;
        }

        elements[size++] = value;
    }
    public int pop(){
        return elements[--size];
    }
    public int peek(){
        return elements[size - 1];
    }
    public boolean empty(){
        return size == 0;
    }
    public int getSize(){
        return size;
    }
}
