package com.cassie.threadTest;
//功能：通过继承Thread开发线程

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cat cat1 = new cat();
		//启动线程,会导致run函数的运行
		cat1.start();
	}

}
class cat extends Thread
{
	//重写run函数
	public void run() {
		int times = 0;
		while(times < 10)
		{
			//休眠一秒
			//1000表示1000毫秒
			//sleep会让线程进入到Blocked状态，并释放资源
			try {
				Thread.sleep(1000);//休眠一秒
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times ++;
			System.out.println("hello world " + times );
			
		}
		
	}
}