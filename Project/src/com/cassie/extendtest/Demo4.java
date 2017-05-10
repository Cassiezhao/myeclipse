package com.cassie.extendtest;

public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CycLink cycLink = new CycLink();
		cycLink.setLength(5);
		cycLink.setK(2);
		cycLink.setM(2);
		cycLink.CreatLink();
		cycLink.print();
		cycLink.play();
	}

}
class Child
{
	
	int no;
	Child nextChild;
	public Child (int no) 
	{
		this.no = no;
	}
}

class CycLink
{
	//先定义一个指向链表头节点的引用
	Child firstChild = null;
	Child temp = null;
	int length = 0;//表示共有几个小孩
	int k = 0;
	int m = 0;
	public void setLength(int length) 
	{
		this.length = length;
	}
	public void setK(int k) {
		this.k = k;
	}
	public void setM(int m) {
		this.m = m;
	}
	//初始化环形链表
	public void CreatLink() 
	{
		for(int i = 1;i <= length;i++)
		{
			if(i == 1)
				//创建第一个节点
			{
				Child ch = new Child(i);
				this.firstChild = ch;
				this.temp = ch;
			}
			else {
				if(i == length)
				{
					Child ch = new Child(i);
					temp.nextChild = ch;
					temp = ch;
					temp.nextChild = this.firstChild;

				}else{

					Child ch = new Child(i);
					temp.nextChild = ch;
					temp = ch;
				}
			}				
		}
	}
	
	public void print() {
		Child temp = this.firstChild;
		do{
			System.out.println(temp.no);
			temp = temp.nextChild;
			
		}while(temp != firstChild);
	}
	//开始play
	public void play() {
		Child temp = this.firstChild;
		//1.先找到开始数数的人
		for(int i = 1;i < k;i++ )
		{
			temp = temp.nextChild;			
		}
		while(this.length != 1){
		//2.数m下
		for(int j = 1;j < m-1; j++)
		{
			temp = temp.nextChild;
		}
		//3.将其从队列内删除
		Child temp2 = temp.nextChild;
		temp.nextChild = temp2.nextChild;
	//	this.print();
		temp = temp.nextChild;
		this.length --;
		
		}
		//输出最后一个小孩
		System.out.println("最后一个:" + temp.no);
	}
}