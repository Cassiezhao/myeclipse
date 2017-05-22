package com.cassie.think;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by cassie on 2017/5/15.
 */
public class ex12_16 {
   public static void main(String [] args) throws Exception{
       if (args.length != 4){
           System.out.println("Usage: java ReplaceText sourceFile targetFile oldStr newStr");
           System.exit(1);
       }
       File sourceFile = new File(args[0]);
       if (!sourceFile.exists()){
           System.out.println("Source File " + args[0] + " does not exits");
           System.exit(2);
       }
       File targetFile = new File(args[1]);
       if (targetFile.exists()){
           System.out.println("Target File " + args[1] + " already exists");
           System.exit(3);
       }
       Scanner input = null;
       PrintWriter output = null;
       try {
           input = new Scanner(sourceFile);
           output = new PrintWriter(targetFile);
       } catch (FileNotFoundException e) {
           e.printStackTrace();
           while(input.hasNext()){
               String s1 = input.nextLine();
               String s2 = s1.replaceAll(args[2],args[3]);
               output.println(s2);
           }
       }


   }
}
