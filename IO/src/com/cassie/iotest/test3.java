package com.cassie.iotest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//功能：演示fileOutStream的使用

public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("/Users/cassie/Desktop/myeclipse/IO/aa.txt");
		FileOutputStream fileOutputStream = null;
		
		try {
			fileOutputStream = new FileOutputStream(file);
			String string = "hello,world,cassie.";
			//byte [] bytes = new byte[1024];
			//如何把String转换成byte
			fileOutputStream.write(string.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}


