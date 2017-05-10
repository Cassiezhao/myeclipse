/*
 * 功能：事件处理机制
 * 
 * */
package com.cassie.tankegame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale.Category;

import javax.swing.*;


public class testevent extends JFrame implements ActionListener{
	
	Mypanel3 mp = null;
	JButton jb1 = null;
	JButton jb2 = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testevent te = new testevent();
	}
	public testevent() {
		// TODO Auto-generated constructor stub
		mp = new Mypanel3();
		jb1 = new JButton("黑色");
		jb2 = new JButton("红色");
		
		this.add(jb1,BorderLayout.NORTH);
		mp.setBackground(Color.BLACK);
		this.add(mp);
		this.add(jb2,BorderLayout.SOUTH);
		
		Cat mycat = new Cat();
		
		//注册监听
		jb1.addActionListener(mycat);
		//指定action命令
		jb1.setActionCommand("a");
		
		jb2.addActionListener(this);
		jb2.setActionCommand("b");
		
		
		
		this.setSize(200, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		//判断是哪个按钮被点击
		if(e.getActionCommand().equals("a"))
		{
			System.out.println("你点击的是黑色按钮。");
			mp.setBackground(Color.blue);
			
		}
		else if(e.getActionCommand().equals("b"))
		{
			
			System.out.println("你点击红色按钮");
			mp.setBackground(Color.red);
		}
		else 
		{
			System.out.println("不知道");
		}
	}
}
class Cat implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("a")) {
			System.out.println("猫也知道你按下了这个黑色按钮");
		}
		else if(e.getActionCommand().equals("b"))
		{
			System.out.println("猫也知道你按下了这个红色按钮");
		}
		else {
			System.out.println("猫猫不知道");
		}
	}
	
}

class Mypanel3 extends JPanel
{
	public void paint(Graphics g) {
		super.paint(g);
	}
}