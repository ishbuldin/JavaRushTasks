package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file1 = new FileInputStream(reader.readLine());
        FileOutputStream file2 = new FileOutputStream(reader.readLine());
        FileOutputStream file3 = new FileOutputStream(reader.readLine());
        byte[] buffer2 = new byte[(file1.available() / 2) + file1.available() % 2];
        byte[] buffer3 = new byte[file1.available() / 2];
        //System.out.println(file1.available() / 2 + file1.available() % 2);
        //System.out.println(file1.available() / 2);
        if (file1.available() > 0) {
            int count2 = file1.read(buffer2);
            file2.write(buffer2, 0, count2);
            int count3 = file1.read(buffer3);
            file3.write(buffer3, 0, count3);
        }
        file1.close();
        file2.close();
        file3.close();
    }
}