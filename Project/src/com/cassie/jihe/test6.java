package com.cassie.jihe;

import java.util.HashMap;


import java.util.Iterator;
public class test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap hp = new HashMap();
		Emp emp1 = new Emp("s001", "aa", 3.4f);
		Emp emp2 = new Emp("s002", "bb", 5.6f);
		Emp emp3 = new Emp("s003", "likui", 1.2f);
		
		hp.put("s001", emp1);
		hp.put("s002", emp2);
		hp.put("s003", emp3);
		
		
		if(hp.containsKey("s002"))
		{
			System.out.println("有这个雇员!!");
		
			Emp emp = (Emp)hp.get("s002");
			System.out.println(emp.getName());
		}
		else {
			System.out.println("没有!!");
		}
		//遍历HashMap中所有的key和value
//		for(int i = 0; i < hp.size();i++)
//		{	
//		}
		//迭代器
		Iterator it = hp.keySet().iterator();
		while(it.hasNext())	
		{
			//取出key
			String key = it.next().toString();
			//通过key取出value
			Emp emp = (Emp)hp.get(key);
			System.out.println("名字：" + emp.getName());
			System.out.println("薪水：" + emp.getSal());
			
		}
	}

}
