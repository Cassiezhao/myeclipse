package com.cassie.jpanel;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class test6 extends JFrame {
	//定义组件
	JTextArea jta;
	JPanel jp1 ;
	JButton jb1;
	JComboBox jcb1;
	JTextField jtf1Field;
	JScrollPane jsp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test6 t6 = new test6();
 	}
	public test6()
	{
		//创建组件
		jta = new JTextArea();
		jp1 = new JPanel();
		String [] chatter = {"cassie","dave"};
		jcb1 = new JComboBox(chatter);
		
		jsp = new JScrollPane(jta);
		jtf1Field = new JTextField(10);
		jb1 = new JButton("发送");
		//设置布局
		
		//添加组件
		jp1.add(jcb1);
		jp1.add(jtf1Field);
		jp1.add(jb1);
		
		//加入JFrame
		this.add(jsp);
		this.add(jp1,BorderLayout.SOUTH);
		
		this.setSize(400,300);
		this.setIconImage(new ImageIcon("..\\images\\ting.jpeg").getImage());
		this.setTitle("聊天记录");
		this.setLocation(200, 200);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
