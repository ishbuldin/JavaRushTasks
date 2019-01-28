package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String f1 = args[0];
        String f2 = args[1];
        BufferedReader fr = new BufferedReader(new FileReader(f1));
        BufferedWriter fw = new BufferedWriter(new FileWriter(f2));
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher;
        String line = null;
        while ((line = fr.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word : words) {
                matcher = pattern.matcher(word);
                if(matcher.find()) {
                    fw.write(word + " ");
                }
            }
        }
        fr.close();
        fw.close();
    }
}
