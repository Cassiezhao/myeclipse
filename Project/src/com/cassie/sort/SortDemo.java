package com.cassie.sort;
import java.lang.reflect.Array;
import java.util.Calendar;

import javax.xml.transform.Templates;
public class SortDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int [] arr = {1,6,0,-1,9,-11,10,-5};
		int len = 10;
		int [] arr = new int[len];
		
		for(int i = 0;i <len;i++)
		{
			arr[i] = (int)(Math.random() * 10000);
		}
		
		
		Bubble bubble = new Bubble();
		Select select = new Select();
		InsertSort insertSort = new InsertSort();
//		FastSort fastSort = new FastSort();
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		
//		select.sort(arr);
//		bubble.sort(arr);
		insertSort.sort(arr);
//		fastSort.sort(0, arr.length - 1, arr);
		cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		
		for(int i = 0;i < arr.length;i++)
		{
			System.out.print( " " + arr[i]);
		}
	}
}
/*class FastSort
{
	public void sort(int right,int left ,int arr[]) {
		
		int l = left;
		int r = right;
		int pivot = arr[(left + right) / 2];
		int temp = 0;
		while(l < r)
		{
			while(arr[l] < pivot) l++;
			while(arr[r] > pivot) r--;
			if(l >= r)
				break;
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			if(arr[l] == pivot)
				--r;
			if(arr[r] == pivot)
				++l;
		}
		
		if(l == r){
			l++;
			r--;
		}
		
		if(left < r) sort(left, r, arr);
		if(right > l) sort(l, right, arr);
		
	}
}*/
class InsertSort
{
	public void sort(int arr[]) {
		for(int i = 1; i < arr.length;i++)
		{
			int insertvalue = arr[i];
			int index = i - 1;
			while (index >= 0 && insertvalue < arr[index]) {
				arr[index + 1] = arr[index];
				index --;				
			}
			arr[index + 1] = insertvalue;
		}
	}
}
class Select
{
	public void sort(int arr[]) {
		int temp = 0;
		for(int j = 0;j < arr.length-1;j++)
		{
			int min = arr[j];
			int minindex = j;
			for(int k = j+1; k < arr.length;k++)
			{
				if(min > arr[k])
				{
					min = arr[k];
					minindex = k;
				}
			}
			//当退出内层循环时，找到此次的最小值
			temp = arr[j];
			arr[j] = arr[minindex];
			arr[minindex] = temp;
		}
	}
}
class Bubble
{
	public void  sort(int arr[]) {
		int temp = 0;
		//排序
		//外层循环，一共走几趟
		for(int i = 0;i < arr.length - 1; i++)
		{ 
			//内层排序，开始逐一比较，如果发现前一个数比后一个数大，则交换
			for(int j = 0; j < arr.length-1-i;j++)
			{
				if(arr[j] > arr[j+1])
				{
					//交换
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] =temp;
				}
			}
		}		
	}
}	

