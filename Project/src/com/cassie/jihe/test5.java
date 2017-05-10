package com.cassie.jihe;

import java.util.Stack;

public class test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s1 = new Stack();
		Emp emp1 = new Emp("01", "aa", 1.2f);
		s1.add(emp1);
		for(int i = 0; i<s1.size();i++)
		{
			Emp emp = (Emp)s1.get(i);
			System.out.println(emp.getName());
		}
	}

}
