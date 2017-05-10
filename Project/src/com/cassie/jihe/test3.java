package com.cassie.jihe;

import java.util.LinkedList;

public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList L1 = new LinkedList();
		
		Emp emp = new Emp("sa01", "aa", 1.2f);
		Emp emp2 = new Emp("sa02", "bb", 1.2f);
		
		L1.addFirst(emp);
		L1.addFirst(emp2);
		
		for(int i = 0;i < L1.size();i++)
		{
			System.out.println(((Emp)L1.get(i)).getName());
		}
	}

}
