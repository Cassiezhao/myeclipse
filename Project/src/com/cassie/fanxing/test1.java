package com.cassie.fanxing;

import java.util.ArrayList;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList aList = new ArrayList();
		//创建了一只狗
		Dog dog1 = new Dog();
		
		aList.add(dog1);
		
		//存在安全隐患
		Cat dog = (Cat)aList.get(0);
				
	}

}

class Cat
{
	private String color;
	private int age;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}


class Dog
{
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}