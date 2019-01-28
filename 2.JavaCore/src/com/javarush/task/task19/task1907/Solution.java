package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        FileReader fr = new FileReader(fileName);
        String[] strings;
        StringBuilder sb = new StringBuilder();
        while (fr.ready()) {
            int a = fr.read();
            sb.appendCodePoint(a);
        }
        fr.close();
        strings = sb.toString().split("\\W");
        int count = 0;
        for (String a : strings) {
            if (a.equals("world")) {
                count++;
            }
        }
            System.out.println(count);
    }
}