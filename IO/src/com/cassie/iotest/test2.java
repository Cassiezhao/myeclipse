package com.cassie.iotest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//功能：演示InputStream类的使用
public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("/Users/cassie/Desktop/myeclipse/IO/aa.txt");
		FileInputStream fileInputStream = null;
		//file没有读写能力 
		try 
		{
			 fileInputStream = new FileInputStream(file);
			//定义一个字节数组，相当于缓存
			byte [] bytes= new byte[1024];
			//实际读取到的字节数
			int n = 0;
			while ((n = fileInputStream.read(bytes)) != -1) 
			{
					//把字节转成String
					String s = new String(bytes, 0, n);
					System.out.println(s);
					
			}
		} 
		catch (IOException e) 
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		finally {
			//关闭文件流
			try 
			{
				fileInputStream.close();
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
