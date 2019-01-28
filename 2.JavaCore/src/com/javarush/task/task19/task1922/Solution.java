package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        //words.add("файл");
        //words.add("вид");
        //words.add("В");
        words.add("A");
        words.add("B");
        words.add("C");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        BufferedReader fr = new BufferedReader(new FileReader(fileName));
        String line = null;
        while ((line = fr.readLine()) != null) {
            int count = 0;
            String[] strings = line.split(" ");
            for (String s : words) {
                for (String word : strings) {
                    if (word.equals(s)) {
                        count++;
                    }
                }
            }
            if (count == 2) {
                System.out.println(line);
            }
        }
        fr.close();
    }
}