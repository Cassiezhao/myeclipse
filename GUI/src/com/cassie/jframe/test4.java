package com.cassie.jframe;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
public class test4 extends JFrame{
	
	int size = 9;
	JButton jbs[]  = new JButton[size];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test4 t4  = new test4();
	}
	public test4()
	{
		for(int i = 0; i < size;i++)
		{
			jbs[i] = new JButton(String.valueOf(i));
		}
		this.setLayout(new GridLayout(3, 3,10,10));
		
		for(int i = 0; i < size; i++)
		{
			this.add(jbs[i]);
		}
		
		this.setTitle("网格布局案例");
		this.setSize(300, 200);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(200, 200);
		
		this.setVisible(true);
	}

}
