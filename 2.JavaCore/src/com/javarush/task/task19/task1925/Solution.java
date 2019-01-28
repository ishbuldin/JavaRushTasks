package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String f1 = args[0];
        String f2 = args[1];
        BufferedReader fr = new BufferedReader(new FileReader(f1));
        BufferedWriter fw = new BufferedWriter(new FileWriter(f2));
        String line = null;
        StringBuilder result = new StringBuilder();

        while ((line = fr.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (word.length() > 6) {
                    result.append(word + ",");
                }
            }
        }
        fw.write(result.toString().substring(0, result.length() - 1));
        fr.close();
        fw.close();

    }
}
