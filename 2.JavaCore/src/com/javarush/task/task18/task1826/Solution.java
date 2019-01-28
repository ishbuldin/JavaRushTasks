package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String fileName = args[1];
        String fileOutputName = args[2];
        FileInputStream fis = new FileInputStream(fileName);
        FileOutputStream fos = new FileOutputStream(fileOutputName);
        switch (args[0]) {
            case "-e":
            {
                while (fis.available() > 0) {
                    int b = (fis.read() * 2) - 13;
                    fos.write(b);
                }
                fis.close();
                fos.close();
            }
            break;
            case "-d":
            {
                while (fis.available() > 0) {
                    int b = (fis.read() + 13) / 2;
                    fos.write(b);
                }
                fis.close();
                fos.close();
            }
            break;
        }
    }
}