/**
 * 
 */
package com.cassie.jdbctest;

/**
 * @author cassie
 *
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
//测试卡片布局是怎么使用的
public class StudentManage extends JFrame implements MouseListener{

	JPanel jpLeft,jpRight,jpRight_1,jpRight_2,jpRight_3;
	JSplitPane jsp;
	JLabel jLabel1,jLabel2,jLabel3;
	CardLayout cardLayout=new CardLayout();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StudentManage();
	}

	//构造函数
	public StudentManage() {
	// TODO Auto-generated constructor stub
		jpLeft=new JPanel(new GridLayout(5,1));
		jpLeft.setBorder(BorderFactory.createEtchedBorder());
		jLabel1=new JLabel("学生选课系统",JLabel.CENTER);
		jLabel1.addMouseListener(this);
		jLabel2=new JLabel("学生管理",JLabel.CENTER);
		jLabel2.addMouseListener(this);
		jLabel3=new JLabel("老师管理",JLabel.CENTER);
		jLabel3.addMouseListener(this);

		jpLeft.add(jLabel1);
		jpLeft.add(jLabel2);
		jpLeft.add(jLabel3);

		jpRight=new JPanel(cardLayout);
		jpRight_1=new JPanel();
		jpRight_1.add(new JLabel(new ImageIcon("sc.jpg")));
		jpRight_1.setBackground(Color.red);
		jpRight_2=new JPanel();
		jpRight_2.setBackground(Color.BLUE);
		jpRight_3=new JPanel();
		jpRight_3.setBackground(Color.BLACK);
		//把jpRight_1 Panel放入到jpRight这个Panel
		jpRight.add("jpRight_1", jpRight_1);
		jpRight.add("jpRight_2", jpRight_2);
		jpRight.add("jpRight_3", jpRight_3);

		//显示哪个panel，是由cardLayout决定的，
		cardLayout.show(jpRight, "jpRight_1");

		jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jpLeft,jpRight);
		//如果我们自己决定左边的panel的宽度
		jsp.setDividerSize(0);
		jsp.setDividerLocation(140);
		this.add(jsp);
		this.setSize(800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount()==1){

			if(e.getSource()==jLabel1){
				cardLayout.show(jpRight, "jpRight_1");
			}else if(e.getSource()==jLabel2){
				cardLayout.show(jpRight, "jpRight_2");
			}else if(e.getSource()==jLabel3){
				cardLayout.show(jpRight, "jpRight_3");
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

		//得到事件源
		((JLabel)e.getSource()).setForeground(Color.RED);

		((JLabel)e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		((JLabel)e.getSource()).setForeground(Color.BLACK);
		((JLabel)e.getSource()).setCursor(new Cursor(Cursor.TEXT_CURSOR));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override	
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
