package com.cassie.threadTest;

//功能：实现Runnale接口
public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog();
		Thread thread = new Thread(dog);
		thread.start();
	}

}
class Dog implements Runnable
{
	int times = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times ++;
			System.out.println("hello world " + times);
			if(times == 10)
				break;
		}
	}
	


}