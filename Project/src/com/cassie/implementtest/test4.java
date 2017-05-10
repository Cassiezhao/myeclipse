package com.cassie.implementtest;

public class test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Aaa a = new Aaa();
		a.show();		
	}
}
class Aaa
{
	int a =0;
	final public void senMes()
	{
		System.out.println("发送消息");
	}
	final void show()
	{
		System.out.println("a = " + a);
	}
}
class Bbb extends Aaa
{
	public Bbb() {
		// TODO Auto-generated constructor stub
		a++;
	}
}
