package com.cassie.jpanel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

/*
 * 功能：词霸
 * */
public class test5 extends JFrame {
	JSplitPane jsp;
	JList jls1;
	JLabel jlb1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test5 t5 = new test5();
	}
	public test5()
	{
		String [] words= {"boy","girl","green","bird"};
		jls1 = new JList(words);
		
		jlb1 = new JLabel(new ImageIcon("\\images\\623010.png"));
		//拆分窗格
		jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jls1,jlb1);
		
		//设置布局管理器
		//添加组件
		this.add(jsp);
		this.setSize(400,300);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
