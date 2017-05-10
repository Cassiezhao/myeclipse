package com.cassie.sort;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,5,7,12,25};
		Binary binfind = new Binary();
		binfind.find(0, arr.length - 1, 17, arr);
	}

}
class Binary
{
	public void find(int leftIndex,int rightIndex,int val,int arr[]) 
	{
		int midIndex = (rightIndex + leftIndex) / 2;
		int midVal = arr[midIndex];
		
		if(rightIndex >= leftIndex)
		{
			if(midVal > val)
			{
				find(leftIndex, midIndex - 1, val, arr);
			}
			else if(midVal < val)
			{
				find(midIndex + 1, rightIndex, val, arr);
			}
			else if(midVal == val) 
			{
				System.out.println("找到下标" + midIndex);
			}
		}
	}
}