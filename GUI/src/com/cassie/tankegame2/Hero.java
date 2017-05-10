package com.cassie.tankegame2;

//我的坦克
class Hero extends Tank
{
	
	public Hero( int x,int y) 
	{
		super(x, y);
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