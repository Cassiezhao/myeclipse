package com.cassie.implementtest;

public class Carshop {
	
	private int money = 0;
	public void sellCar(Car car) {
		System.out.println("车型：" + car.getName() + " 价格：" + car.getPrice());
		money += car.getPrice();
	}
	public int getMoney() {
		return money;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Carshop carshop = new Carshop();
		carshop.sellCar(new BMW());
		carshop.sellCar(new cheryQq());
		System.out.println("总收入：" + carshop.getMoney());
	}

}
interface Car
{
	String getName();
	int getPrice();
}
class BMW implements Car
{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "BMW";
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 300000;
	}
	
}
class cheryQq implements Car
{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "cheryQq";
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 20000;
	}	
}