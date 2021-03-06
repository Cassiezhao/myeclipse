package com.cassie.tankegame2;

//我的坦克
class Hero extends Tank
{	
	Shot shot = null;
	
	public Hero( int x,int y) 
	{
		super(x, y);
		
	}
	
	//开火
	public void shotEnemy()
	{
		
		switch (this.direct) {
		case 0:
			  	shot = new Shot(x + 10, y, 0);
			  	break;
		case 1:
				shot = new Shot(x + 30, y + 10, 1);
				break;
		case 2:
				shot = new Shot(x + 10, y +30, 2);
				break;
		case 3:
				shot = new Shot(x, y + 10, 3);
				break;
		}
		//启动子弹线程
		Thread thread = new Thread(shot);
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