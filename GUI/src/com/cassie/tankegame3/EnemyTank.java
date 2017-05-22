package com.cassie.tankegame3;

import java.util.Vector;

//敌人坦克类
public class EnemyTank extends Tank implements Runnable{
	//boolean isLive = true;
	//定义一个向量，存放敌人的子弹
	Vector<Shot> ss = new Vector<Shot>();
	//敌人添加子弹，应当在刚创建坦克和敌人的坦克子弹死亡后
	public EnemyTank(int x ,int y)
	{
		super(x, y);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while (true) {
				
			switch (this.direct) 
			{
			case 0:
				  	//说明坦克在向上走
					for (int i = 0; i < 20; i++) {
						if (y > 0) {
							y-=speed;
						}						
						try 
						{
							Thread.sleep(50);
						} 
						catch (Exception e) 
						{
							// TODO: handle exception
							e.printStackTrace();
						}
					}
					
					break;
			case 1:
					for (int i = 0; i < 20; i++) {
						if (x < 370) {
							x+= speed;
						}			
						try 
						{
							Thread.sleep(50);
						} 
						catch (Exception e) 
						{
							// TODO: handle exception
							e.printStackTrace();
						}
					}
					
					break;
			case 2:
					for (int i = 0; i < 20; i++) {
						if (y < 370) {
							y+= speed;
						}

						try 
						{
							Thread.sleep(50);
						} 
						catch (Exception e) 
						{
							// TODO: handle exception
							e.printStackTrace();
						}
					}
					break;
			case 3:
					for (int i = 0; i < 20; i++) {
						if (x > 0) {
							x-= speed;
						}

						try 
						{
							Thread.sleep(50);
						} 
						catch (Exception e) 
						{
						// TODO: handle exception
						e.printStackTrace();
						}
					}
			}
			
			//让坦克随机产生一个新的方向
			this.direct = (int)(Math.random() * 4);
			//判断敌人坦克是否死亡
			if (this.isLive == false) {
				//让坦克死亡后，退出线程
				break;
			}
		
		}
	}
}
