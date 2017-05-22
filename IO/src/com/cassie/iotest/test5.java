
package com.cassie.iotest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author cassie
 * @fun 演示文件字符流的案例
 */
public class test5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
			// TODO Auto-generated method stub
		//文件取出字符流对象
		FileReader fr = null;
		//写入到文件
		FileWriter fw = null;
		
		try 
		{
			fr = new FileReader("/Users/cassie/Desktop/myeclipse/IO/aa.txt");
			fw = new FileWriter("/Users/cassie/Desktop/myeclipse/IO/aa-1.txt");
			int n =0;//记录实际读取到的字符数
			//读入到内存
			char [] c = new char[1024];
			while ((n = fr.read(c)) != -1) 
			{
				//System.out.println(c);
				fw.write( c, 0, n);
			}			
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
