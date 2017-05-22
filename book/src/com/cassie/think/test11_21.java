package com.cassie.think;

/**
 * Created by cassie on 2017/5/16.
 */
public class test11_21 {
    public static void main(String[] args) {
        new Person().printPerson();
        new Student().printPerson();
    }
}

    class Student extends Person{
//        @Override
        private String getInfo(){
            return "Student";
        }
    }
    class Person{
        private String getInfo(){
            return "Person";
        }
        public void printPerson(){
            System.out.println(getInfo());
        }
    }


