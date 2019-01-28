package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        ArrayList<Integer> alphabetCodes = new ArrayList<>();
        for (int i = 65; i <= 90; i++) {
            alphabetCodes.add(i);
        }
        for (int i = 97; i <= 122; i++) {
            alphabetCodes.add(i);
        }
        int count = 0;
        while (fileInputStream.available() > 0) {
            if (alphabetCodes.contains(fileInputStream.read())) {
                count++;
            }
        }
        fileInputStream.close();
        System.out.println(count);
    }
}