/**
 * 添加学生
 */
package com.cassie.stumanage2;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.jdbc.log.Jdk14Logger;

/**
 * @author cassie
 *
 */
public class stuAddDialog extends JDialog implements ActionListener{
	//定义需要的控件
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	JPanel jp1,jp2,jp3;
	
	//owner父窗口，title窗口的名字，modal指定是模式窗口还是非模式窗口
	public stuAddDialog(Frame owner,String title,boolean modal) {
		// TODO Auto-generated constructor stub
		super(owner,title,modal);//调用父类构造方法，达到模式对话框效果
		jl1 = new JLabel("学号");
		jl2 = new JLabel("姓名");
		jl3 = new JLabel("性别");
		jl4 = new JLabel("年龄");
		jl5 = new JLabel("籍贯");
		jl6 = new JLabel("系别");
		
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jtf3 = new JTextField();	
		jtf4 = new JTextField();
		jtf5 = new JTextField();
		jtf6 = new JTextField();
		
		jb1 = new JButton("添加");
		jb1.addActionListener(this);
		jb2 = new JButton("取消");
		jb2.addActionListener(this);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jp1.setLayout(new GridLayout(6,1));
		jp2.setLayout(new GridLayout(6,1));
		
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		//jb1.addActionListener(this);
		
		this.setSize(300,200);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jb1) {
			Connection conn = null;
			//Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement ps = null;
			try {
				//1、加载驱动
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("driver");
				//2、得到连接
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cassie","root","pass@word01");
				System.out.println(conn);
				//3、
				String strsql = "insert into students value(?,?,?,?,?,?)";
				ps = conn.prepareStatement(strsql);
				//4、
				ps.setString(1, jtf1.getText());
				ps.setString(2, jtf2.getText());
				ps.setString(3, jtf3.getText());
				ps.setString(4, jtf4.getText());
				ps.setString(5, jtf5.getText());
				ps.setString(6, jtf6.getText());			
				ps.executeUpdate();
				//关机添加对话框
				this.dispose();
				
			} catch (ClassNotFoundException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}catch (SQLException e3) {
				// TODO: handle exception
				e3.printStackTrace();
			}finally {			
				try {
					if (rs != null) rs.close();				
					if (ps != null) ps.close();
					if (conn != null) conn.close();
				} catch (SQLException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}			
			}
 		}else if (e.getSource() == jb2) {
 			this.dispose();
		} 
	}
}
