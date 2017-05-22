package com.cassie.think;

import java.util.Date;

/**
 * Created by cassie on 2017/5/15.
 */
public abstract class ex13_1 {


    private String color = "white";


    private boolean filled;


    Date dateCreated;

    public ex13_1(){
        dateCreated = new Date();
    }
    public ex13_1(String color,boolean filled){
        dateCreated = new Date();
        this.color = color;
        this.filled = filled;
    }
    public String getColor() {
        return color;
    }
    public boolean isFilled(){
        return  filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "ex13_1{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                ", dateCreated=" + dateCreated +
                '}';
    }
    public abstract double getArea();
    public abstract double getPerimeter();

    public static void main(String [] args){
        Circle c1 = new Circle(1);
        System.out.println("A circle is " + c1.toString());
        System.out.println("the color id " + c1.getColor());
        System.out.println("the area of c1 :" + c1.getArea());
        System.out.println("the perimeter of c1 is " + c1.getPerimeter());
        Rectangle r1 = new Rectangle(2,4);
        System.out.println("A rectangle is " + r1.toString());
        System.out.println("the area of r1 :" + r1.getArea());
        System.out.println("the perimeter of r1 is " + r1.getPerimeter());
    }
}
