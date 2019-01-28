package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();
        br.close();
        BufferedReader fr = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = fr.readLine()) != null) {
            for (int i = line.length() - 1; i >= 0; i--) {
                System.out.print(line.charAt(i));
            }
            System.out.println();
        }
        fr.close();
    }
}
