/**
 * 对数据库操作的类
 */
package com.cassie.stumanage4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author cassie
 *
 */
public class sqlHelper {
	//定义操作数据库需要的
		PreparedStatement ps = null;
		Connection ct = null;
		ResultSet rs = null;
		String url = "jdbc:mysql://localhost:3306/cassie";
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String password = "pass@word01";
		//查询数据库
		public ResultSet queryExecute(String sql,String[] para) {
			
			try {
				//1、加载驱动
				Class.forName(driver);
				//2、得到连接
				ct = DriverManager.getConnection(
						url,user,password);
				//3、创建对象
				ps = ct.prepareStatement(sql);
				for (int i = 0; i < para.length; i++) {
					ps.setString(i+1, para[i]);
				}
				rs = ps.executeQuery();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		}
		public ResultSet queryExecute(String sql) {
			try {
				//1、加载驱动
				Class.forName(driver);
				//2、得到连接
				ct = DriverManager.getConnection(
						url,user,password);
				//3、创建对象
				ps = ct.prepareStatement(sql);
				rs = ps.executeQuery();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		}
		//增删改
		public boolean updExecute(String sql,String [] para) {
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
					this.close();			
			}
			return b;
		}
		public void close() {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (ct != null)	ct.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
