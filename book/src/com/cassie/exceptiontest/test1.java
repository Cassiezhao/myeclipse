/**
 * 
 */
package com.cassie.exceptiontest;

import java.util.Scanner;

/**
 * @author cassie
 * @fun 捕获异常
 */
public class test1 {

	/**
	 * @param number1,number2 
	 * @fun  number1/number2
	 */
	public static int quotient(int number1,int number2) 
	{
		if (number2 == 0) {
			throw new ArithmeticException("Divisor cannot be zero.");
		}
		return number1/number2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("enter two numbers:");
		
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		try 
		{
			int result = quotient(number1, number2);
			System.out.println("number1 " + "/ " + "number2 " + result);
		} 
		catch (ArithmeticException e) 
		{
			// TODO: handle exception
			System.out.println("exception: an integer " + "cannot br divided by zero");
		}
		System.out.println("Execution continues...");
		//System.out.println(1.0/0);
		//System.out.println(1/0);
	}

}
