package com.cassie.tankegame;

//1、一个类要实现监听的步骤
//a.实现相应的接口 keyListener,MouseListener..
//b.把接口的处理方法根据需要重新编写
//c.在事件源上注册监听
//d.事件传递是靠事件对象

import javax.swing.JFrame;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
/*
 * 坦克大战V1.0
 * 1、画坦克
 * */
public class tanke extends JFrame {
	Mypanel mp;
	public static void main(String[] args) {
		
		tanke mtk = new tanke();
	}
	public tanke()
	{
		mp = new Mypanel();
		this.add(mp);
		this.addKeyListener(mp);
		
		this.setSize(400,400);
		this.setVisible(true);
		
	}
  
}



//我的面板
class Mypanel extends JPanel implements KeyListener
{
	//定义一个我的坦克
	Hero hero = null;
	int y ;
	int x ;
	public Mypanel()
	{
		hero = new Hero(100, 100);
		x = hero.getX();
		y = hero.getY();
	}

	public void drawTank(int x,int y,Graphics g,int direct,int type) 
	{
		
		switch (type) 
		{
			case 0:
					g.setColor(Color.CYAN);
					break;
			case 1:
					g.setColor(Color.yellow);
					break;
		}
		//判断方向
		switch (direct) 
		{
			case 0://向上
				//画出我的坦克
				//1、画出左面的矩形
				g.fill3DRect(x, y, 5, 30, false);
				//2、画出右边的矩形
				g.fill3DRect(x + 15, y, 5, 30, false);
				//3、画出中间矩形
				g.fill3DRect(x + 5, y+5, 10, 20, false);
				//4、画出圆形
				g.fillOval(x + 5, y + 10, 10, 10);
				//5、画出线
				g.drawLine(x + 10, y + 20, x + 10, y);
				break;
		}
		
	}
	
	//重写paint函数
	public void paint(Graphics g)
	{	
		super.paint(g);
		g.fillRect(0, 0, 400, 400);
		this.drawTank(hero.getX(), hero.getY(), g, 0, 0);		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//			System.out.println("12");
			
			y+= 5;
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			y-=5;
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			x+=5;		
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			x-=5;
		}
		
		//调用repaint()函数
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

class Tank
{
	//表示坦克的横坐标
	int x = 0;
	//表示坦克的纵坐标
	int y = 0;
	
	public Tank (int x,int y) 
	{
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}	
	
}


//我的坦克
class Hero extends Tank
{
	public Hero( int x,int y) 
	{
		super(x, y);
	}
}