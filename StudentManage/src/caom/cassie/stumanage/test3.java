/**
 * 
 */
package caom.cassie.stumanage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



/**
 * @author cassie
 *
 */
public class test3 extends JFrame implements ActionListener{

	/**
	 * @param args
	 */
	JPanel jp1,jp2;
	JLabel jl1;
	JButton jb1,jb2,jb3,jb4;
	JTable jt;
	JScrollPane jsp;
	JTextField jtf;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test3 test3 = new test3();
	}
	public  test3() {
		jp1 = new JPanel();
		jtf = new JTextField(10);
		jb1 = new JButton("查询");
		jb1.addActionListener(this);
		//jb1.setActionCommand("");
		jl1 = new JLabel("请输入名字");
		
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		
		jp2 = new JPanel();
		jb2 = new JButton("添加");
		jb2.addActionListener(this);
		jb3 = new JButton("修改");
		jb3.addActionListener(this);
		jb4 = new JButton("删除");
		jb4.addActionListener(this);
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		
		stuModel stuModel = new stuModel();
		
		jt = new JTable(stuModel);		
		jsp = new JScrollPane(jt);		
		this.add(jsp);
		this.add(jp1,"North");
		this.add(jp2,"South");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jb1) {
			System.out.println("用户查询");
			//查询数据库
			String name = this.jtf.getText().trim();
			String sql = "select * from students where stuName = '"+name+"'";
			stuModel stuModel = new stuModel(sql);
			jt.setModel(stuModel);
		}else if (e.getSource() == jb2) {
			stuAddDialog sta = new stuAddDialog(this, "添加学生信息",false);
			//重新再获得新的数据模型
			
		}
	}

}
