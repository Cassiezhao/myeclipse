package com.cassie.jpanel;
/*
 * 功能：复选框和单选框
 * */

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.*;
public class test3 extends JFrame {
	JPanel jp1,jp2,jp3;
	JLabel jbl1,jbl2;
	
	JButton jb1,jb2;
	JCheckBox jcb1,jcb2,jcb3;
	JRadioButton jrb1,jrb2;
	
	ButtonGroup bg1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test3 t3 = new test3();
	}
	public test3()
	{
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jbl1 = new JLabel("你喜欢的运动");
		jbl2 = new JLabel("你的性别   ");
		
		jb1 = new JButton("注册用户");
		jb2 = new JButton("取消注册");
		
		jcb1 = new JCheckBox("足球");
		jcb2 = new JCheckBox("篮球");
		jcb3 = new JCheckBox("乒乓球");
		
		jrb1 = new JRadioButton("男");
		jrb2 = new JRadioButton("女");
		
		bg1 = new ButtonGroup();
		bg1.add(jrb1);
		bg1.add(jrb2);
		
		this.setLayout(new GridLayout(3, 1));
		
		jp1.add(jbl1);
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jcb3);
		
		jp2.add(jbl2);
		jp2.add(jrb1);
		jp2.add(jrb2);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setSize(300,150);
		
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
