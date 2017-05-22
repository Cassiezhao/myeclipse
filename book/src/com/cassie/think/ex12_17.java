package com.cassie.think;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by cassie on 2017/5/15.
 */
public class ex12_17 {
    public static void main(String [] args)  {
        System.out.println("enter a URL:");
        String URLString = new Scanner(System.in).next();

        URL url1 = null;

        try {
            url1 = new URL(URLString);
            int count = 0;
            Scanner input = new Scanner(url1.openStream());
            while(input.hasNext()){
                String lines = input.nextLine();
                count += lines.length();
            }
            System.out.println("the file size is " + count + "charaters.");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Invaild URL");
        }catch (IOException ex){
            System.out.println("I/O error: no such file!");
        }
    }
}
