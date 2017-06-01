/**
 * 
 */
package com.cassie.stumanage4;

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
	//查询的本质就是初始化
	public void queryStu(String sql,String [] para) {
		sqlHelper sqlHelper = null;
		ResultSet rs;
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
			sqlHelper = new sqlHelper();
			rs = sqlHelper.queryExecute(sql, para);
			
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
			sqlHelper.close();				
		}
	}
	
	//增删改
	public boolean updStu(String sql,String[] para) {
		//创建一个sqlHelper(如果程序并发性不考虑，可以把sqlHelper做成static)
		sqlHelper sqlHelper = new sqlHelper();
		return sqlHelper.updExecute(sql, para);
	}
	
	//用于初始化数据模型
	
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
