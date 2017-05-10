package com.cassie.extendtest;
/*
 * 演示多态
 * */
public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	cat cat1 = new cat();
		cat1.cry();
		dog dog1 = new dog();
		dog1.cry();
		Animal animal1 = new dog();
		animal1.cry();
		Animal animal2 = new cat();
		animal2.cry();
		animal1.eat();
		animal2.eat();
		*/
		Master master = new Master();
		master.feed(new dog(), new Bone());
		master.feed(new cat(), new Fish());
	}

}
class Master 
{
	//给动物喂食
	public void feed(Animal an,Food f) {
		an.eat();
		f.showName();
	}
}
class Food
{
	String name;
	public void showName() 
	{
		
	}
}
class Fish extends Food
{
	public void showName() 
	{
		System.out.println("鱼");
	}
}
class Bone extends Food
{
	public void showName() 
	{
		System.out.println("骨头");
	}
}
class Animal
{
	String name;
	int age;
	
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
	public void cry() {
		System.out.println("不知道怎么叫");
		
	}
	public void eat() {
		System.out.println("不知道吃什么");
	}
}
class cat extends Animal{
	public void cry(){
		System.out.println("我是猫猫，我喵喵叫。");
	}
	public void eat() {
		System.out.println("猫喜欢吃鱼");
	}
}
class dog extends Animal{
	public void cry() {
		System.out.println("我是狗，我汪汪叫。");
	}
	public void eat() {
		System.out.println("狗喜欢吃骨头");
	}
}