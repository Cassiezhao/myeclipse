/**
 * 
 */
package com.cassie.iotest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author cassie
 * @fun  演示缓冲字符流案例
 */
public class test6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		BufferedWriter bw = null;
		//先创建FileReader，再升级BufferedReader
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("/Users/cassie/Desktop/myeclipse/IO/aa.txt");
			br = new BufferedReader(fr);
			
			fw = new FileWriter("/Users/cassie/Desktop/myeclipse/IO/ee.txt");
			bw = new BufferedWriter(fw);
			//循环读取文件
			String s = " ";
			while ((s = br.readLine()) != null) {
				
				System.out.print(s);				
				bw.write(s + "\r\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				fw.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
