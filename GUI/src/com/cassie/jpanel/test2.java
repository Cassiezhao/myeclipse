package com.cassie.jpanel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.*;
public class test2 extends JFrame {
	JPanel jp1,jp2,jp3;
	JLabel jlb1,jlb2;	
	JButton jb1,jb2;	
	JTextField jtf1;
	JPasswordField jpf1;
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test2 t2 = new test2(); 
	}
	public test2() {
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jlb1 = new JLabel("用户名");
		jlb2 = new JLabel("密   码");
		
		jb1 = new JButton("登陆");
		jb2 = new JButton("取消");
		
		jtf1 = new JTextField(10);
		jpf1 = new JPasswordField(10);
		
		this.setLayout(new GridLayout(3, 1,10,10));
		
		jp1.add(jlb1);
		jp1.add(jtf1);
		
		jp2.add(jlb2);
		jp2.add(jpf1);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setSize(240,160);
		
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
