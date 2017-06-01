/**
 * 
 */
package com.cassie.jdbctest;

import java.util.Properties;

import javax.management.RuntimeErrorException;

import org.w3c.dom.CDATASection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.sql.ResultSet;


/**
 * @author cassie
 * @fun 对数据库的操作封装到一个类中
 */
public class SqlHelper {
	//定义需要的变量
	//如果访问数据库很频繁，则不需要用static
	private static Connection ct = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static CallableStatement cs = null;
	
	public static Connection getCt() {
		return ct;
	}
	
	public static PreparedStatement getPs() {
		return ps;
	}
	
	public static ResultSet getRs() {
		return rs;
	}
	

	
	//连接数据库参数
	private static String url = "";
	private static String username = "";
	private static String driver= "";
	private static String password = "";
	
	private static Properties properties = null;
	private static FileInputStream fileInputStream = null;
	static{
		try {
			//从dbinfo.properties中读取配置信息
			properties = new Properties();
			fileInputStream = new FileInputStream("dbinfo.properties");
			properties.load(fileInputStream);
			
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");

			Class.forName(driver);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				fileInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fileInputStream = null;
		}
	}
	//得到连接
	public static Connection getConnection() {
		try {
			ct = DriverManager.getConnection(url,username,password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ct;
	}
	//分页问题？
	public static ResultSet executeQuery2() {
		return null;
	}
	
	//调用存储过程 像{call过程(?,?,?)}
	public static void callProl(String sql,String[] parameters) {
		try {
			ct = getConnection();
			cs = ct.prepareCall(sql);
			//?号赋值
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					cs.setObject( i+1, parameters[i]);
				}
			}
			cs.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());		
		}finally {
			close(rs, cs, ct);
		}
	}
	//统一的select
	public static ResultSet executeQuery(String sql,String [] parameters) {
		try {
			ct = getConnection();
			ps = ct.prepareStatement(sql);
			if (parameters != null && parameters.equals("")) {
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i+1, parameters[i]);
				}
			}
			rs = ps.executeQuery();			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());				
		}finally {
//			close(rs, ps, ct);
		}
		return rs;
		
	}
	//如果有多个update/delete/insert（需要考虑事务）
	public static void executeUpdate2(String sql[],String [][] parameters) {
		try {
			//1.获得连接
			ct  = getConnection();
			//用户传入多个sql语句时
			ct.setAutoCommit(false);
			
			for (int i = 0; i < sql.length; i++) {
				if (parameters[i] != null) {
					ps = ct.prepareStatement(sql[i]);
					for (int j = 0; j < parameters[i].length; j++) {
						ps.setString(j+1,parameters[i][j] );
					}
					ps.executeUpdate();
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());	
		}finally {
			close(rs, ps, ct);
		}
	}
	//先写一个update/delete/insert
	//sql 格式：update 表名 set 字段名 = ? where 字段 = ?
	//parameter应该是("abc",123)
	public static void executeUpdate(String sql,String [] parameters) {
		//先创建一个ps
		
		try {
			ct = getConnection();
			ps = ct.prepareStatement(sql);
			//给？赋值
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i+1, parameters[i]);
				}
			}
			//执行
			ps.executeUpdate();
			
//			ct.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//抛出异常,可以给调用该函数的函数一个选择
			//可以处理，也可以不处理
			throw new RuntimeException(e.getMessage());			
		}finally {
			//关闭资源
			close(rs,ps,ct);
		}
		
		  
	}
	public static void close(ResultSet rs,Statement ps,Connection ct) {
		//关闭资源
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ps = null;//使用垃圾回收
		}
		
		if (ct != null) {
			try {
				ct.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ct = null;
		}
		
	}
}
	

