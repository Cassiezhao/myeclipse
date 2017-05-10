package com.cassie.jihe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class test2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		EmpManage em = new EmpManage();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true)
		{
			System.out.println("请选择你要进行的操作：");
			System.out.println("1.添加一个雇员");
			System.out.println("2.查找一个雇员：");
			System.out.println("3.修复一个雇员工资");
			System.out.println("4.删除一个雇员");
			System.out.println("5.退出系统");
			String operType = br.readLine();
			if(operType.equals("1"))
			{
				System.out.println("请输入编号");
				String empNo = br.readLine();
				System.out.println("请输入名字");
				String name = br.readLine();
				System.out.println("请输入工资");
				float sal = Float.parseFloat(br.readLine());
				
				Emp emp = new Emp(empNo, name, sal);
				em.addEmp(emp);
			}
			
			else if(operType.equals("2"))
			{
				System.out.println("请输入编号");
				String empNo = br.readLine();
				em.showInfo(empNo);
				
			}
			else if (operType.equals("3"))
			{
				System.out.println("请输入要修改工资的雇员编号");
				String empNo = br.readLine();
				
				System.out.println("请输入新的工资");
				float sal = Float.parseFloat(br.readLine());
				
				em.updateSal(empNo, sal);
				
			}
			else if(operType.equals("4"))
			{
				System.out.println("请输入要删除雇员的员工号:");
				String empNo = br.readLine();
				em.delEmp(empNo);
			}
			else if (operType.equals("5")) {
				System.out.println("已退出系统!!");
				System.exit(0);
			}
			
		}
	}

}
//雇员管理类
class EmpManage
{
	private ArrayList aList =  new ArrayList();

	public EmpManage() {
	}

	//加入员工
	public void addEmp(Emp emp) {
		
		aList.add(emp);
	}
	//显示员工信息，根据员工号
	public void showInfo(String empNo) {
		//遍历整个ArrayList
		for(int i = 0; i < aList.size();i++)
		{
			//取出Emp对象
			Emp emp = (Emp)aList.get(i);
			if(emp.getEmpNo().equals(empNo))
			{
				System.out.println("员工信息");
				System.out.println("姓名：" + emp.getName() +
						" 编号：" + emp.getEmpNo() + " 薪水：" + emp.getSal());
				break;
			}
		}
	}
	//更新薪水
	public void updateSal(String empNo,float newSal)
	{
		for(int i = 0;i < aList.size();i++)
		{
			Emp emp = (Emp)aList.get(i);
			if(emp.getEmpNo().equals(empNo))
			{
				emp.setSal(newSal);
			}
		}
	}
//删除一个员工
	public void delEmp(String empNo) {
		for(int i = 0; i < aList.size();i++)
		{
			Emp emp = (Emp)aList.get(i);
			if(emp.getEmpNo().equals(empNo))
			{
				aList.remove(i);
			}
		}
	}
}


//雇员类
class Emp{
	private String empNo;
	private String name;
	private float sal;
	
	public Emp(String empNo, String name, float sal) {
		
		this.empNo = empNo;
		this.name = name;
		this.sal = sal;
	}
	
	public String getEmpNo() {
		return empNo;
	}
	
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public float getSal() {
		return sal;
	}
	
	public void setSal(float sal) {
		this.sal = sal;
	}
}
