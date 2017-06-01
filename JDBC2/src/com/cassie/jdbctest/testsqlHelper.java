/**
 * 
 */
package com.cassie.jdbctest;

import org.junit.Test;

import java.sql.ResultSet;

/**
 * @author cassie
 *
 */
public class testsqlHelper {

	/**
	 * 测试sqlHelper工具类是否可以正常使用
	 */
//	@Test
//	public void testsqlhlper() {
//		System.out.println("ok");
//		String sql = "insert into user1 values(?,?,?,?,?,?)";
//		String param[] = {"7","mike","123",
//		                "smith@gmail.com","2017-05-23","28"};
//		SqlHelper.executeUpdate(sql, param);
//	}
//	@Test
//	public void testsqlhelper2(){
//		String sql1 = "UPDATE user1 SET passwd='234' WHERE 'id'=?";
//		String sql2 = "UPDATE user1 SET age='26' WHERE id=?";
//		String sqlString[] ={sql1,sql2};
//		String sqlString_para1[] = {"2"};
//		String sqlString_para2[] = {"7"};
//		String sqlString_paras[][] = {sqlString_para1,sqlString_para2};
//		SqlHelper.executeUpdate2(sqlString, sqlString_paras);
//		
//	}
//	@Test
//	public void testsqlhelper3(){
//		String sql = "select * from user1";
//		try {
//			ResultSet rs= SqlHelper.executeQuery(sql, null);
//			System.out.println(rs);
//			while (rs.next()) {
//				System.out.println(rs.getObject("id") + "\t"
//						+ rs.getObject("name") + "\t"
//						+ rs.getObject("passwd") + "\t"
//						+ rs.getObject("email") + "\t"
//						+ rs.getObject("birthday") + "\t"
//						+ rs.getObject("age"));
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}finally {
//			System.out.println(SqlHelper.getRs());
//			SqlHelper.close(SqlHelper.getRs(),
//					SqlHelper.getPs(), SqlHelper.getCt());
//		}
//		
//		}
	@Test
	public void testSeq(){
		try {
			String sql = "{call new_procedure(?)}";
			String param[] = {"10"};
			SqlHelper.callProl(sql, param);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}

	

