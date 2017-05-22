/**
 * 
 */
package com.cassie.exceptiontest;

/**
 * @author cassie
 * @fun 
 */
public class test3 {

	/**
	 * @param args
	 */
	private double radius;
	
	private static int numberOfObjects = 0;
	
	public test3() {
		this(1.0);
	}
	public  test3(double newRadius) {
		setRadius(newRadius);
		numberOfObjects++;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double newRadius) throws IllegalArgumentException 
	{
		
			if (newRadius >= 0) {
				radius = newRadius;
			}
			else {
				throw new IllegalArgumentException("Radius cannot be negative");
			}
		
	}
	public static int  getNumberOfObjects() {
		return numberOfObjects;
	}
	public double findArea() {
		return radius * radius * Math.PI;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			test3 c1 = new test3(5);
			test3 c2 = new test3(-5);
			test3 c3 = new test3(0);
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		System.out.println("Number of object created :" +
				test3.getNumberOfObjects());
	}

}
