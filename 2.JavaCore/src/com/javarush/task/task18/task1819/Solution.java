package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileInputStream fis1 = new FileInputStream(fileName1);
        byte[] file1buff = new byte[fis1.available()];
        if (fis1.available() > 0) {
            fis1.read(file1buff, 0, file1buff.length);
        }
        fis1.close();
        FileOutputStream fos1 = new FileOutputStream(fileName1);
        FileInputStream fis2 = new FileInputStream(fileName2);
        byte[] file2buff = new byte[fis2.available()];
        if (fis2.available() > 0) {
            fis2.read(file2buff, 0 , file2buff.length);
        }
        fis2.close();
        fos1.write(file2buff);
        fos1.write(file1buff);
        fos1.close();
    }
}