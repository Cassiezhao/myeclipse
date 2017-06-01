/**
 * 
 */
package com.cassie.jdbctest;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;



/**
 * @author cassie
 *
 */
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test1();
		
		Connection ct = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		
		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			//2.得到连接
			ct = DriverManager.getConnection("jdbc:mysql://localhost/cassie","root","pass@word01");
			System.out.println("Datebase connected " + ct);
			//3.创建对象(Statement/PreparedStatement/CallableStatement)
//			ps= ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
//					ResultSet.CONCUR_READ_ONLY);
			ps = ct.prepareStatement("select * from user1 "
					+ "where id=? and passwd=?'");
			ps.setInt(1, 1);
			ps.setString(2, "123");
			
			//4.通过statement向数据库发送sql指令
//
			result = ps.executeQuery();
			
			while(result.next()){
//				System.out.println(result.getObject("id") + "\t"
//						+ result.getObject("name") + "\t"
//						+ result.getObject("passwd") + "\t"
//						+ result.getObject("email") + "\t"
//						+ result.getObject("birthday") + "\t"
//						+ result.getObject("age"));
				System.out.println(result.getString(2));
			}
			//默认情况下result只能向前，不能向后，这样result就不能复用
			//如果希望复用，则需要result.beforeFirst();
			//如果希望重新使用result
//			result.beforeFirst();
//			result.absolute(1);
//			System.out.println("again");
//			while (result.next()) {
//				System.out.println(result.getObject("id") + "\t"
//						+ result.getObject("name") + "\t"
//						+ result.getObject("passwd") + "\t"
//						+ result.getObject("email") + "\t"
//						+ result.getObject("birthday") + "\t"
//						+ result.getObject("age"));
//				
//			}
		} 
		catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭资源
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ps = null;//使用垃圾回收
			if (ct != null) {
				try {
					ct.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ct = null;
			
		}
	}

	private static void test1() {
		Connection ct = null;
		Statement statement = null;
		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			//2.得到连接
			ct = DriverManager.getConnection("jdbc:mysql://localhost/cassie","root","pass@word01");
			System.out.println("Datebase connected " + ct);
			//3.创建对象(Statement/PreparedStatement/CallableStatement)
			statement= ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
			//4.通过statement向数据库发送sql指令
//
			ResultSet result = statement.executeQuery("select * from user1");
			
			while(result.next()){
				System.out.println(result.getObject("id") + "\t"
						+ result.getObject("name") + "\t"
						+ result.getObject("passwd") + "\t"
						+ result.getObject("email") + "\t"
						+ result.getObject("birthday") + "\t"
						+ result.getObject("age"));
			}
			//默认情况下result只能向前，不能向后，这样result就不能复用
			//如果希望复用，则需要result.beforeFirst();
			//如果希望重新使用result
//			result.beforeFirst();
			result.absolute(1);
			System.out.println("again");
			while (result.next()) {
				System.out.println(result.getObject("id") + "\t"
						+ result.getObject("name") + "\t"
						+ result.getObject("passwd") + "\t"
						+ result.getObject("email") + "\t"
						+ result.getObject("birthday") + "\t"
						+ result.getObject("age"));
				
			}
		} 
		catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭资源
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			statement = null;//使用垃圾回收
			if (ct != null) {
				try {
					ct.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ct = null;
			
		}
	}

}
