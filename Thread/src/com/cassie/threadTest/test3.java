package com.cassie.threadTest;

import java.security.Timestamp;

//两个线程同时运行的案例

public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pig pig =new Pig(10);
		Bird bird = new Bird(10);
		Thread t1 =new Thread(bird);
		Thread t2 =new Thread(pig);
		t1.start();
		t2.start();
	}

}
class Pig implements Runnable
{
	int n = 0;
	int times = 0;
	public Pig(int n)
	{
		this.n = n;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times ++;
			System.out.println("我是一个线程，在输出第 " + times + " hello world");
			if(n == times)
				break;
		}
	}

}
class Bird implements Runnable
{
	//算数学题
	int n = 0;
	int res = 0;
	int times;
	public Bird(int n) {
		// TODO Auto-generated constructor stub
		this.n = n;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			res += (++times);
			System.out.println("当前结果是 " + res);
			if(times == n)
			{
				System.out.println("最后结果是 " + res);
			}
		}
	}
	
	
}