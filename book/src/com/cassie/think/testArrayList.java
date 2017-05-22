package com.cassie.think;

import java.util.ArrayList;

/**
 * Created by cassie on 2017/5/16.
 */
public class testArrayList {
    public static void main(String [] args){
        ArrayList<String> cityList = new ArrayList<>();

        cityList.add("London");
        cityList.add("Denver");
        cityList.add("Paris");
        cityList.add("Miami");
        cityList.add("Seoul");
        cityList.add("Tokyo");

        System.out.println("list size " + cityList.size());

        System.out.println("is Miami in list " + cityList.contains("Miami"));
        System.out.println("the location of Denver in the list " + cityList.indexOf("Denver"));
        System.out.println("is ths list empty " + cityList.isEmpty());

        cityList.add(2,"Xian");
        cityList.remove("Miami");

        cityList.remove(1);
        System.out.println(cityList.toString());

        for(int i = cityList.size() -1; i > 0; i--){
            System.out.println(cityList.get(i) + " ");
        }
        System.out.println();

        ArrayList<Circle> list = new ArrayList<>();
        list.add(new Circle(2));
        list.add(new Circle(3));

        System.out.println("the area of the circle is " + list.get(0).getArea());

    }
}
