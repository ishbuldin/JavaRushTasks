package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            URL url = new URL(reader.readLine());
            String[] paramsString = url.toExternalForm().split("\\?");
            String[] params = paramsString[1].split("&");
            String objValue = null;
            for (String str : params) {
                String[] name = str.split("=");
                if (name[0].equals("obj"))
                    objValue = name[1];
                System.out.print(name[0] + " ");
            }
            if (objValue != null) {
                if (objValue.matches("\\d+\\.\\d+") || objValue.matches("\\d+")) {
                    System.out.println();
                    alert(Double.parseDouble(objValue));
                }
                else alert(objValue);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
