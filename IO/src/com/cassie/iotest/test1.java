package com.cassie.iotest;

import java.io.File;
import java.io.IOException;

//功能：File类的基本用法
public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		File file = new File("/Users/cassie/Desktop/myeclipse/IO");
//		System.out.println("文件路径：" + file.getAbsolutePath());
//		System.out.println(file.length());
//		System.out.println("可读：" + file.canRead());
//		System.out.println("可写：" + file.canWrite());
		//创建文件和创建文件夹
//		File file = new File("/Users/cassie/Desktop/myeclipse/IO/bb.txt");
//		if (! file.exists()) {
//			//可以创建
//			try {
//				file.createNewFile();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		else {
//			System.out.println("有文件，不能创建");
//		}
//		File file = new File("/Users/cassie/Desktop/myeclipse/IO/cc");
//		if (file.isDirectory()) {
//			System.out.println("文件存在");
//		}
//		else {
//			file.mkdir();
//		}
		
		//显示文件夹下所有文件
		File file = new File("/Users/cassie/Desktop/myeclipse/IO");
		if (file.isDirectory()) {
			File list[] = file.listFiles();
			for (int i = 0; i < list.length; i++) {
				System.out.println("文件名：" + list[i].getName());
			}
		}
	}

}
