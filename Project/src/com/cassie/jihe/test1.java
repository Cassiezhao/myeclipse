package com.cassie.jihe;

/*
 * 功能：演示Java集合的用法
 * */

import java.util.*;
public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList aList = new ArrayList();
		
//		System.out.println("alist大小:" + aList.size());
		
		clerk c1 = new clerk("松江", 40, 1200);
		aList.add(c1);//存放了c1的地址
		
		clerk c2 = new clerk("吴勇", 45, 1500);
		aList.add(c2);
		
		clerk c3 = new clerk("林冲", 38, 1600);
		aList.add(c3);
		
		aList.add(c1);
		
//		clerk temp = (clerk)aList.get(0);
//		System.out.println("第一个的名字是：" + temp.getName());
//		
		
		//遍历alist所有的对象
		for(int i = 0; i < aList.size();i++)
		{
			clerk temp1 = (clerk)aList.get(i);
			System.out.println("名字= " + temp1.getName());
		}
		
		//删除一个对象
		aList.remove(1);
		
		System.out.println("----删除吴勇----");
		for(int i = 0; i < aList.size();i++)
		{
			clerk temp1 = (clerk)aList.get(i);
			System.out.println("名字= " + temp1.getName());
		}
	}

}
class clerk
{
	private String name;
	private int age;
	private float sal;
	public clerk(String name, int age, float sal) 
	{
		this.name = name;
		this.age = age;
		this.sal = sal;
	}
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
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	
}