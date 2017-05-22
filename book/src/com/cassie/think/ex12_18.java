package com.cassie.think;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by cassie on 2017/5/15.
 */
public class ex12_18 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a URL:");
        String url = input.nextLine();
        crawler(url);
    }

    public static void crawler(String startingUrl){
        ArrayList<String> listOfPendingURLs =new ArrayList<>();
        ArrayList<String> listOfTraversedURLS = new ArrayList<>();

        listOfPendingURLs.add(startingUrl);
        while(!listOfPendingURLs.isEmpty() && listOfTraversedURLS.size() <= 100){
            String urlString = listOfPendingURLs.remove(0);
            if (!listOfTraversedURLS.contains(urlString)){
                listOfTraversedURLS.add(urlString);
                System.out.println("Crawl " + urlString);

                for(String s:getSubURLs(urlString)){
                    if (!listOfTraversedURLS.contains(s)){
                        listOfPendingURLs.add(s);
                    }
                }

            }
        }
    }

    private static ArrayList<String> getSubURLs(String urlString) {
        ArrayList<String> list = new ArrayList<>();

        URL url = null;
        try {
            url = new URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0;
            while(input.hasNext()){
                String line = input.nextLine();
                current = line.indexOf("http:",current);
                while(current > 0){
                    int endIndex = line.indexOf("\"",current);
                    if (endIndex > 0){
                        list.add(line.substring(current,endIndex));
                        current = line.indexOf("http:",endIndex);
                    }
                    else{
                        current = -1;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
            e.printStackTrace();
        }

        return  list;
    }
}
