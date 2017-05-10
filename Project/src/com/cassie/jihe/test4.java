package com.cassie.jihe;

import java.util.Vector;

public class test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector v1 = new Vector();
		
		Emp emp1= new Emp("1","aa", 1.2f);
		v1.add(emp1);
		for(int i = 0; i<v1.size();i++)
		{
			Emp emp = (Emp)v1.get(i);
		}
				
				
	}

}
