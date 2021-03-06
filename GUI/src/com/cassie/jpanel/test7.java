package com.cassie.jpanel;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class test7 extends JFrame{
	//北部区域
	JLabel jbl1;
	//南部区域
	JButton jb1,jb2,jb3;
	JPanel jp1;
	//中部区域
	JTabbedPane jtp;//选项卡窗格
	JPanel jp2,jp3,jp4;
	//QQ号码、QQ密码、忘记密码
	JLabel jbl2,jbl3,jbl4,jbl5;
	//号码文本框
	JTextField jtf;
	//密码
	JPasswordField jpf;
	//清除号码
	JButton jb4;
	//隐身登录和记住密码
	JCheckBox jcb1,jcb2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test7 t7 = new test7();
	}
	public test7()
	{
		jbl2 = new JLabel("QQ号码",JLabel.CENTER);
		jbl3 = new JLabel("QQ密码",JLabel.CENTER);
		jbl4 = new JLabel("忘记密码",JLabel.CENTER);
		jbl4.setFont(new Font("宋体",Font.PLAIN,16));
		jbl4.setForeground(Color.blue);
		
		jbl5 = new JLabel("<html><a href='www.qq.com'>申请密码保护</a>");
		jbl5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//输入密码框
		jtf = new JTextField();
		jpf = new JPasswordField();
		
		jb4 = new JButton("清除号码");
		
		jcb1 = new JCheckBox("隐身登录");
		jcb2 = new JCheckBox("记住密码");
		
		//北部区域
		jbl1 = new JLabel("背景图");
		
		//南部区域
		jp1 = new JPanel();
		jb1 = new JButton("登录");
		jb2 = new JButton("取消");
		jb3 = new JButton("注册向导");
		
		//中部区域
		jtp = new JTabbedPane();
		jp2 = new JPanel();
		
		jp3 = new JPanel();
		jp3.setBackground(Color.RED);
		jp4 = new JPanel();
		jp4.setBackground(new Color(0,0,255));
		
		//将面板添加到选项卡上
		jtp.add("QQ号码",jp2);
		jtp.add("手机号码",jp3);
		jtp.add("电子邮箱",jp4);
		
		jp2.setLayout(new GridLayout(3,3));
		//底层三个按钮
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		//中部布局
		jp2.add(jbl2);
		jp2.add(jtf);
		jp2.add(jb4);
		
		jp2.add(jbl3);
		jp2.add(jpf);
		jp2.add(jbl4);
		
		
		jp2.add(jcb1);
		jp2.add(jcb2);
		jp2.add(jbl5);
		
		this.add(jp1,BorderLayout.SOUTH);
		this.add(jbl1,BorderLayout.NORTH);
		this.add(jtp,BorderLayout.CENTER);
		this.setTitle("登录界面");
		this.setSize(350,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
}
