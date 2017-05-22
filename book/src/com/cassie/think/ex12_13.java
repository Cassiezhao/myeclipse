package com.cassie.think;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by cassie on 2017/5/15.
 */
public class ex12_13{
    public static void main(String [] args) throws Exception{
        File file = new File("aa.txt");


        if (file.exists()){
            System.out.println("File already exists");
            System.exit(1);
        }
        PrintWriter output = null;
        try {
            output = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        output.print("John T Smith ");
        output.println(90);
        output.print("Eric K Jones ");
        output.println(85);
        output.close();

        Scanner input = new Scanner(file);
        while(input.hasNext()){
            String firstName = input.next();
            String mi = input.next();
            String lastName = input.next();
            int score = input.nextInt();
            System.out.println(firstName+ " " + mi + " " + lastName + " " + score);
        }
        input.close();
    }
}