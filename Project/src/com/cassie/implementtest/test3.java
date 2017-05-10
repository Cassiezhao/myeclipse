package com.cassie.implementtest;
/*
 * 功能：接口的讲解
  */
public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer computer = new Computer();
		Camera camera = new Camera();
		Phone phone = new Phone();
		computer.useUsb(camera);
		computer.useUsb(phone);
	}

}
interface Usb
{
	int a = 1;
	public void start();
	public void stop();
}
//当一个类实现了一个接口，就要求该类把这个接口的所有方法全部实现
class Camera implements Usb
{
	@Override
	public void start() 
	{
	// TODO Auto-generated method stub
	System.out.println("我是相机，开始工作了");
	}

	@Override
	public void stop() 	
	{
	// TODO Auto-generated method stub
	System.out.println("我是相机，停止工作了");
	}
}
class Phone implements Usb
{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("我是手机，开始工作了");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("我是手机，停止工作了");
	}
	
}
class Computer 
{
	public void useUsb(Usb usb) {
		usb.start();
		usb.stop();
	}
}
class Base
{
	
}

