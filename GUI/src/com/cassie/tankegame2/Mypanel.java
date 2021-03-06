package com.cassie.tankegame2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JPanel;

//我的面板
class Mypanel extends JPanel implements KeyListener,Runnable
{
	//定义一个我的坦克
	Hero hero = null;
	//定义敌人的坦克
	Vector<EnemyTank> ets = new Vector<EnemyTank>();
	int enSize = 3;

	public Mypanel()
	{
		hero = new Hero(100, 100);
		
		for (int i = 0; i < enSize; i++) {
			//创建一个敌人的坦克，并加入
			EnemyTank et = new EnemyTank((i+1) * 50, 0);
			et.setColor(1);
			et.setDirect(2);
			ets.add(et);
		}
	}
	
	//画一个坦克
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
				
			case 1://向右
				//画出我的坦克
				//1、画出上面的矩形
				g.fill3DRect(x, y, 30, 5, false);
				//2、画出下面的矩形
				g.fill3DRect(x , y + 15, 30, 5, false);
				//3、画出中间矩形
				g.fill3DRect(x + 5, y + 5, 20, 10, false);
				//4、画出圆形
				g.fillOval(x + 10, y + 5, 10, 10);
				//5、画出线
				g.drawLine(x + 15, y + 10, x + 30, y + 10);
				break;
			case 2://向下
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
				g.drawLine(x + 10, y + 15, x + 10, y + 30);
				break;
			case 3://向左
				//画出我的坦克
				//1、画出上面的矩形
				g.fill3DRect(x, y, 30, 5, false);
				//2、画出下面的矩形
				g.fill3DRect(x , y + 15, 30, 5, false);
				//3、画出中间矩形
				g.fill3DRect(x + 5, y + 5, 20, 10, false);
				//4、画出圆形
				g.fillOval(x + 10, y + 5, 10, 10);
				//5、画出线
				g.drawLine(x + 15, y + 10, x , y + 10);
				break;
		}
		
	}
	
	//重写paint函数
	public void paint (Graphics g)
	{	
		super.paint(g);
		
		g.fillRect(0, 0, 400, 400);
		//画出自己的坦克
		this.drawTank(hero.getX(), hero.getY(), g, this.hero.direct, 0);		
		
		//画出子弹
		if (hero.shot != null) {
			g.fill3DRect(hero.shot.x-2, hero.shot.y - 2, 4, 4, false);
		}
		
		//画出敌人的坦克
		for (int i = 0; i < ets.size(); i++) 
		{
			this.drawTank(ets.get(i).getX(), ets.get(i).getY(),
					g, ets.get(i).getDirect(), 1);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub、
		//键按下处理a表示向左 s表示下 w 上 d右
		//0表示上 1表示右 2 表示下  3表示左
		if (e.getKeyCode() == KeyEvent.VK_W) {
			
			//设置我的坦克的方向
			this.hero.setDirect(0);
			this.hero.moveUp();
		}
		else if (e.getKeyCode() == KeyEvent.VK_D) {
			this.hero.setDirect(1);
			this.hero.moveRight();
		}
		else if (e.getKeyCode() == KeyEvent.VK_S)
		{
			this.hero.setDirect(2);
			this.hero.moveDown();	
		}
		else if (e.getKeyCode() == KeyEvent.VK_A)
		{
			this.hero.setDirect(3);
			this.hero.moveLeft();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_J)
		{
			//判断玩家是否按下j
			//开火
			this.hero.shotEnemy();
			
		}
		
		//必须重新绘制panel，调用repaint()函数
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.repaint();
		}
	}
}


