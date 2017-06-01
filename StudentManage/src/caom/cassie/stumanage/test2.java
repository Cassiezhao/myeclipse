/**
 * 
 */
package caom.cassie.stumanage;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author cassie
 *
 */
public class test2 extends JFrame {

	Vector rowData,columnNames;
	JTable jt = null;
	JScrollPane jsp2 = null;
	
	//定义操作数据库需要的
	PreparedStatement ps = null;
	Connection ct = null;
	ResultSet rs = null;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test2 test = new test2();
	}
	public test2() {
		
		columnNames = new Vector();
		
		//设置列名
		columnNames.add("学号");
		columnNames.add("姓名");
		columnNames.add("年龄");
		columnNames.add("性别");
		columnNames.add("籍贯");
		columnNames.add("系别");
		
		rowData = new Vector();
		
		try {
			//1、加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver");
			//2、得到连接
			ct = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cassie","root","pass@word01");
			System.out.println(ct);
			//3、创建对象
			ps = ct.prepareStatement("select * from students");
			System.out.println(ps);
			//4、
			rs = ps.executeQuery();
			System.out.println(rs);
			
			while (rs.next()) {
				
				Vector hang = new Vector();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getInt(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				
				rowData.add(hang);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
				try {
					if (rs != null) {
						rs.close();
					}
					if (ps != null) {
						ps.close();
					}
					if (ct != null) {
						ct.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		jt = new JTable(rowData,columnNames);		
		jsp2 = new JScrollPane(jt);		
		this.add(jsp2);
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}


}
