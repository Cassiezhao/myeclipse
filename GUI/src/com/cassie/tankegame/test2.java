package com.cassie.tankegame;
/*
 * 功能：让小球受到键盘的控制--上下左右移动
 * */

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class test2 extends JFrame {
	Mypanel4 mp = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test2 t2 = new test2();
	}
	public test2() 
	{
		mp = new Mypanel4();
		
		this.add(mp);
		this.addKeyListener(mp);
		
		this.setSize(400,300);
		this.setVisible(true);
	}

}

//定义panel
class Mypanel4 extends JPanel implements KeyListener
{
	int x = 10;
	int y = 10;
	
	public void paint(Graphics g) {
		super.paint(g);
		
		g.fillOval(x, y, 10, 10);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("键被按下:"+e.getKeyChar());
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//			System.out.println("12");
			y+=5;
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
