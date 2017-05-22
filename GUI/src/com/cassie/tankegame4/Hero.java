package com.cassie.tankegame4;

import java.util.Vector;

//我的坦克
class Hero extends Tank
{	
	//子弹
	//Shot shot = null;
	
	Vector<Shot> ss = new Vector<Shot>();
	Shot s = null;
	
	public Hero( int x,int y) 
	{
		super(x, y);
		
	}
	
	//开火
	public void shotEnemy()
	{
		
		switch (this.direct) 
		{
			case 0:
				//创建一颗子弹
			  	s = new Shot(x + 10, y, 0);
			  	//把子弹加入向量
			  	ss.add(s);
			  	break;
			case 1:
				s = new Shot(x + 30, y + 10, 1);
				ss.add(s);
				break;
			case 2:
				s = new Shot(x + 10, y +30, 2);
				ss.add(s);
				break;
			case 3:
				s = new Shot(x, y + 10, 3);
				ss.add(s);
				break;
		}
		
		//启动子弹线程
		Thread thread = new Thread(s);
		thread.start();
	}
	//坦克向上移动
	public void moveUp() 
	{
		y-=speed;
	}
	//坦克向右移动
	public void moveRight() 
	{
		x+=speed;
	}
	//坦克向下移动
	public void moveDown() 
	{
		y+=speed;
	}
	//坦克向左移动
	public void moveLeft()
	{
		x-=speed;
	}	
}