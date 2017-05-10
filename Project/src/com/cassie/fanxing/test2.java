package com.cassie.fanxing;

import java.lang.reflect.Method;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gen<Bird> gen1 = new Gen<Bird>(new Bird());
		gen1.showTypeName();
		
	}

}
class Gen<T>
{
	private T oT;
	
	public Gen(T oT) {
		this.oT = oT;
	}

	public void showTypeName(){
		System.out.println("类型是:" + oT.getClass().getName());
		
		//通过反射机制，可以得到T的更多信息
		Method [] methods = oT.getClass().getDeclaredMethods();
		for(int i = 0;i<methods.length;i++)
		{
			
			System.out.println("成员函数：" + methods[i].getName());
		}
	}
}
class Bird
{
	public void test1() {
		
		System.out.println("aa");
	}
	public void conut(int a,int b) {
		
		System.out.println(a+b);
	}
}