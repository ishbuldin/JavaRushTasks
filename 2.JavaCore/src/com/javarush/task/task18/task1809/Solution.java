package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());
        byte[] bytes = new byte[fileInputStream.available()];
        if (fileInputStream.available() > 0) {
            int count = fileInputStream.read(bytes);
        }
        for (int i = bytes.length - 1; i >= 0; i--) {
            fileOutputStream.write(bytes[i]);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}