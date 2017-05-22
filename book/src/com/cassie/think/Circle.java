package com.cassie.think;

/**
 * Created by cassie on 2017/5/15.
 */
public class Circle  extends ex13_1{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }
    public double getDiameter(){
        return 2 * radius;
    }

    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
