package com.cassie.jframe;

import java.awt.*;
import javax.swing.*;
public class test3 extends JFrame{
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test3 test3 = new test3();
	}
	public test3() {
		jb1 = new JButton("关羽");
		jb2 = new JButton("张飞");
		jb3 = new JButton("赵云");
		jb4 = new JButton("马超");
		jb5 = new JButton("魏延");
		jb6 = new JButton("黄忠");
		
		
		//设置布局管理器
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.add(jb1);
		this.add(jb2);	
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		
		this.setTitle("流式布局案例");
		this.setSize(400, 200);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		
		
	}

}
