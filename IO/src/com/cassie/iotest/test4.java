/**
 * 
 */
package com.cassie.iotest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author cassie
 * @fun： 图片拷贝
 */
public class test4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("/Users/cassie/Desktop/myeclipse/GUI/src/6.jpg");
			fos = new FileOutputStream("/Users/cassie/Desktop/myeclipse/GUI/src/6-1.jpg");
			byte buffer[] = new byte[512];
			int n = 0;//记录实际读到的字节数
			//循环读取
			while ((n=fis.read(buffer)) != -1) 
			{
						
				fos.write(buffer);			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
			
			
		} 
			
			
}

