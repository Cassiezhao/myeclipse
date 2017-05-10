package com.cassie.jpanel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
/*
 * 功能：多种布局管理器组合
 * 
 * */
public class test1 extends JFrame{
	//定义组件
	JPanel jp1,jp2;
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1 t1 = new test1();
	}
	public test1()
	{
		//创建组件
		jp1 = new JPanel();
		jp2 = new JPanel();
		jb1 = new JButton("西瓜");
		jb2 = new JButton("苹果");
		jb3 = new JButton("荔枝");
		jb4 = new JButton("葡萄");
		jb5 = new JButton("桔子");
		jb6 = new JButton("香蕉");
		
		//设置布局管理器
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		
		this.add(jp1,BorderLayout.NORTH);
		this.add(jb6,BorderLayout.CENTER);
		this.add(jp2,BorderLayout.SOUTH);
		
		this.setSize(300,200);
		this.setLocation(200, 200);
		this.setVisible(true);
		
	}
}
