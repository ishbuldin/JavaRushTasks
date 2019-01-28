package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        String filename = null;
        FileInputStream inputStream;
        //ArrayList<Integer> data = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            filename = reader.readLine();
            inputStream = new FileInputStream(filename);
            while (inputStream.available() > 0) {
                //data.add(inputStream.read());
                System.out.print((char) inputStream.read());
            }
            reader.close();
            inputStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //for (int a : data) {
        //    System.out.println((char)a);
        //}
    }
}