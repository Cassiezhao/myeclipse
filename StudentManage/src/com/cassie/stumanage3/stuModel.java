/**
 * 
 */
package com.cassie.stumanage3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

/**
 * @author cassie
 *
 */
public class stuModel extends AbstractTableModel {

	/**
	 * @param args
	 */

	Vector rowData,columnNames;
	//定义操作数据库需要的
	PreparedStatement ps = null;
	Connection ct = null;
	ResultSet rs = null;
	String url = "jdbc:mysql://localhost:3306/cassie";
	String driver = "com.mysql.jdbc.Driver";
	String user = "root";
	String password = "pass@word01";
	public void init(String sql) {
		if (sql.equals("")) {
			sql = "select * from students";
		}
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
			Class.forName(driver);
			System.out.println("driver");
			//2、得到连接
			ct = DriverManager.getConnection(
					url,user,password);
			System.out.println(ct);
			//3、创建对象
			ps = ct.prepareStatement(sql);
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
	}
	//增删改
	public boolean updStu(String sql,String[] para) {
		boolean b = true;

		try {
			//1、加载驱动
			Class.forName(driver);
			//2、得到连接
			ct = DriverManager.getConnection(
					url,user,password);			
			//3、创建对象
			ps = ct.prepareStatement(sql);
			for (int i = 0; i < para.length; i++) {
				ps.setString(i + 1, para[i]);
			}
			//4、
			if (ps.executeUpdate() != 1) {
				b = false;
			}		
		} catch (Exception e) {
			// TODO: handle exception
			b = false;
			e.printStackTrace();
		}finally {			
				try {
					if (rs != null) rs.close();
					if (ps != null) ps.close();
					if (ct != null)	ct.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
		}
		return b;
	}
	//通过传递的sql语句来获得数据模型
	public  stuModel(String sql) {
		this.init(sql);
	}
	//用于初始化数据模型
	public stuModel() {
		this.init("");
		
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)(this.columnNames.get(column));
	}

	//得到共有多少行
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		
		return this.rowData.size();
	}
	//得到共有多少列
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}
	//得到某行某列的数据
	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(row)).get(column);
	}

}
