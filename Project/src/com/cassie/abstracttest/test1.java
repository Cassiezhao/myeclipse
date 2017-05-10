package com.cassie.abstracttest;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
abstract class Animal
{
	String name;
	int age;
	abstract public void cry(); 
	
}
//当一个类继承的父类是抽象类的话，
//需要我们把抽象类中的所有抽象方法全部实现。
class Cat extends Animal
{
	@Override
	//实现父类cry
	public void cry() {
		// TODO Auto-generated method stub
		System.out.println("猫喵喵叫");
	}
	
}
class Dog extends Animal
{

	@Override
	public void cry() {
		// TODO Auto-generated method stub
		System.out.println("狗汪汪叫");
	}
	
}
