package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int count = 0;
        int len = fileInputStream.available();
        while (fileInputStream.available() > 0) {
            if (fileInputStream.read() == 32) {
                count++;
            }
        }
        fileInputStream.close();
        float a = (float) count / len * 100;
        System.out.printf("%.2f", a);
    }
}