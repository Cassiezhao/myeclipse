package com.cassie.jframe;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
/*
 * 功能：gui界面开发
 * */
public class test1 extends JFrame{
	
	JFrame jFrame = new JFrame();
	JButton jButton1 = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1 test1 = new test1();
			
	}
	public test1 () {
	//JFrame是一个顶层容器类（可以添加其他swing组件的类）
		
		
		jButton1 = new JButton("我是按钮");
		//给窗体设置标题
		this.setTitle("hello cassie !");
		//设置大小
		this.setSize(400, 400);
		this.add(jButton1);
		//当关闭窗口时，保证JVM也关闭
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//显示
		this.setVisible(true);
		this.setLocation(100, 200);
	}

}
