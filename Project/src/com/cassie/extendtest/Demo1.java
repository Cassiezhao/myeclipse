package com.cassie.extendtest;
class stu {
	public int age;
	public String name;
	public double fee;
	public void printname() {
		System.out.println("name:" + this.name);
	}
}
class Pupil extends stu{
	
	public void pay(double fee) {
		this.fee = fee;
	}
}
class Middle extends stu{
	
	public void  pay(double fee) {
		this.fee = 0.8 * fee;
	}
}
class College extends stu{
	public void pay(double fee) {
		this.fee = 0.1 * fee;
	}
}
public class Demo1 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pupil p1= new Pupil();
		p1.age = 20;
		p1.printname();
	}

}
