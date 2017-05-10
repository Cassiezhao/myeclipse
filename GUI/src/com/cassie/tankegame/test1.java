package com.cassie.tankegame;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class test1 extends JFrame{
	
	MyPanel2 mPane;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1 t1 = new test1();
	}
	public test1()
	{
		mPane = new MyPanel2();
		this.add(mPane);
		
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

//定义一个panel，用于绘图和显示绘图的区域
class MyPanel2 extends JPanel
{
	//覆盖JPanel的paint方法
	//graphics是绘图的重要类，可以当做一支画笔
	public void paint(Graphics g) {
		//1.调用父类函数完成初始化
		//不能少
		super.paint(g);
		//2.画一个圆
		//g.drawOval(30, 30, 40, 40);
		//g.drawLine(10, 10, 40, 40);
		//g.drawRect(10, 10, 80, 80);
		//g.draw3DRect(80, 80, 40, 40, true);
		//g.setColor(Color.gray);
		//g.fillRect(120, 120, 40, 40);
		g.setColor(Color.black);
		g.setFont(new Font("隶书",Font.BOLD,30));
		g.drawString("hi,cassie!", 100, 100);
	}
	
}