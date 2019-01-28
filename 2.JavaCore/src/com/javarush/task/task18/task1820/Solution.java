package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        BufferedReader filereader = new BufferedReader(new InputStreamReader(fis));
        FileOutputStream fos = new FileOutputStream(reader.readLine(), true);
        String[] digits;
        digits = filereader.readLine().split(" ");
        fis.close();
        filereader.close();
        String string = "";
        for (String str : digits) {
            int number = Math.round(Float.parseFloat(str));
            string += String.valueOf(number) + " ";
        }
        fos.write(string.getBytes());
        fos.close();
    }
}