package com.cassie.jpanel;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

/*
 * JComboBox/JList/JscrollPane
 * */
public class test4 extends JFrame {
	JPanel jp1,jp2;
	JLabel jbl1,jbl2;
	JComboBox jcb1Box;
	JList jls1;
	JScrollPane jsp;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test4 t4 = new test4();
	}
	public test4()
	{
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		jbl1 = new JLabel("你的籍贯");
		jbl2 = new JLabel("旅游地点");
		
		String [] jg = {"北京","上海","天津","重庆","西安"};	
		jcb1Box = new JComboBox(jg);
		
		String [] lydd = {"九寨沟","黄山","故宫","长城"};
		jls1 = new JList(lydd);
		jls1.setVisibleRowCount(2);
		jsp = new JScrollPane(jls1);
		
		
		//设置布局
		this.setLayout(new GridLayout(3, 1));
		jp1.add(jbl1);
		jp1.add(jcb1Box);
		
		jp2.add(jbl2);
		jp2.add(jsp);
		
		this.add(jp1);
		this.add(jp2);

		this.setSize(300,200);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
