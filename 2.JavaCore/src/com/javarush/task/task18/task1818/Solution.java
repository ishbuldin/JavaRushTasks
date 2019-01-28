package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        FileOutputStream file1 = new FileOutputStream(filename1);
        FileInputStream file2 = new FileInputStream(reader.readLine());
        FileInputStream file3 = new FileInputStream(reader.readLine());

        byte[] file2buff = new byte[file2.available()];
        if (file2.available() > 0) {
            file2.read(file2buff, 0, file2buff.length);
        }

        file1.write(file2buff);
        file1.close();

        byte[] file3buff = new byte[file3.available()];
        if (file3.available() > 0) {
            file3.read(file3buff, 0, file3buff.length);
        }

        file1 = new FileOutputStream(filename1, true);
        file1.write(file3buff);
        file1.close();
        file2.close();
        file3.close();
    }
}