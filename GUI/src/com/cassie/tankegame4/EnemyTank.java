package com.cassie.tankegame4;

import java.util.Vector;

//敌人坦克类
public class EnemyTank extends Tank implements Runnable{
	//boolean isLive = true;
	//定义一个向量  可以访问到Mypanel上所有敌人的坦克
	Vector<EnemyTank> ets = new Vector<EnemyTank>();
	
	//定义一个向量，存放敌人的子弹
	Vector<Shot> ss = new Vector<Shot>();
	
	//敌人添加子弹，应当在刚创建坦克和敌人的坦克子弹死亡后
	public EnemyTank(int x ,int y)
	{
		super(x, y);
	}
	
	//得到mypanel的敌人坦克向量
	public void setEts(Vector<EnemyTank> vv) 
	{
		this.ets = vv;
	}
	
	//判断是否撞到了别人的坦克
	public boolean isTouchOtherEnemy() 
	{
		boolean b = false;
		switch (this.direct) 
		{
			case 0:
				//我的坦克向上
				//取出所有敌人坦克
				for (int i = 0; i < ets.size(); i++) 
				{
					EnemyTank et = ets.get(i);
					//如果不是自己
					if (et != this) 
					{
						//如果敌人方向向上或向下
						if (et.direct == 0 || et.direct ==2) 
						{
							//我的左一点
							if (this.x >= et.x && this.x <= et.x + 20 
									&& this.y >= et.y && this.y <= et.y + 30) 
							{
								return true;
							}
							//右点
							if (this.x + 20 >= et.x && this.x + 20 <= et.x + 20 
									&& this.y >= et.y && this.y <= et.y + 30) {
								return true;
							}
						}
						if (et.direct == 1 || et.direct ==3) 
						{
							//左点
							if (this.x >= et.x && this.x <= et.x + 30 
									&& this.y >= et.y && this.y <= et.y + 20) 
							{
								return true;
							}
							//右点
							if (this.x + 20 >= et.x && this.x +20 <= et.x + 30 
									&& this.y >= et.y && this.y <= et.y + 20) {
								return true;
							}
							
						}
						
					}
				}
				break;

			case 1:
				//我的坦克向右
				//取出所有敌人坦克
				for (int i = 0; i < ets.size(); i++) 
				{
					EnemyTank et = ets.get(i);
					//如果不是自己
					if (et != this) 
					{
						//如果敌人方向向上或向下
						if (et.direct == 0 || et.direct ==2) 
						{
							//我的上一点
							if (this.x + 30 >= et.x  && this.x + 30 <= et.x + 20 
									&& this.y >= et.y && this.y <= et.y + 30) 
							{
								return true;
							}
							//我的下一点
							if (this.x + 30 >= et.x && this.x + 30 <= et.x + 20 
									&& this.y + 20 >= et.y && this.y + 20 <= et.y + 30) {
								return true;
							}
						}
						if (et.direct == 1 || et.direct ==3) 
						{
							//我的上一点
							if (this.x +30 >= et.x && this.x +30 <= et.x + 30 
									&& this.y  >= et.y && this.y  <= et.y + 20) 
							{
								return true;
							}
							//我的下一点
							if (this.x + 30 >= et.x && this.x +30 <= et.x + 30 
									&& this.y +20 >= et.y && this.y + 20 <= et.y + 20) 
							{
								return true;
							}
						}
					}
				}
				break;
			case 2:
				//我的坦克向下
				//取出所有敌人坦克
				for (int i = 0; i < ets.size(); i++) 
				{
					EnemyTank et = ets.get(i);
					//如果不是自己
					if (et != this) 
					{
						//如果敌人方向向上或向下
						if (et.direct == 0 || et.direct ==2) 
						{
							//我的左一点
							if (this.x  >= et.x  && this.x <= et.x + 20 
									&& this.y + 30 >= et.y && this.y + 30 <= et.y + 30) 
							{
								return true;
							}
							//我的右一点
							if (this.x + 20 >= et.x && this.x +20 <= et.x + 20 
									&& this.y + 30 >= et.y && this.y + 30 <= et.y + 30) 
							{
								return true;
							}
						}
						if (et.direct == 1 || et.direct ==3) 
						{
							//我的左一点
							if (this.x >= et.x && this.x  <= et.x + 30 
									&& this.y +30 >= et.y && this.y +30 <= et.y + 20) 
							{
								return true;
							}
							//我的右一点
							if (this.x + 20 >= et.x && this.x +20 <= et.x + 30 
									&& this.y +30 >= et.y && this.y + 30 <= et.y + 20) 
							{
								return true;
							}
						}
					}
				}
				break;
			case 3:
				//我的坦克向左
				//取出所有敌人坦克
				for (int i = 0; i < ets.size(); i++) 
				{
					EnemyTank et = ets.get(i);
					//如果不是自己
					if (et != this) 
					{
						//如果敌人方向向上或向下
						if (et.direct == 0 || et.direct ==2) 
						{
							//我的上一点
							if (this.x >= et.x  && this.x  <= et.x + 20 
									&& this.y >= et.y && this.y <= et.y + 30) 
							{
								return true;
							}
							//我的下一点
							if (this.x >= et.x && this.x  <= et.x + 20 
									&& this.y + 20 >= et.y && this.y + 20<= et.y + 30) 
							{
								return true;
							}
						}
						if (et.direct == 1 || et.direct ==3) 
						{
							//我的上一点
							if (this.x  >= et.x && this.x <= et.x + 30 
									&& this.y  >= et.y && this.y <= et.y + 20) 
							{
								return true;
							}
							//我的下一点
							if (this.x  >= et.x && this.x  <= et.x + 30 
									&& this.y + 20 >= et.y && this.y + 20 <= et.y + 20) 
							{
								return true;
							}
						}
					}
				}
				break;
		}
		return b;
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
						if (y > 0 && !this.isTouchOtherEnemy()) {
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
						if (x < 360 && !this.isTouchOtherEnemy()) {
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
						if (y < 370 && !this.isTouchOtherEnemy()) {
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
						if (x > 0 && !this.isTouchOtherEnemy()) {
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
