package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        br.close();
        BufferedReader fr = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fw = new BufferedWriter(new FileWriter(fileName2));
        StringBuilder sb = new StringBuilder();
        while (fr.ready()) {
            sb.appendCodePoint(fr.read());
        }
        fw.write(sb.toString().replaceAll("[.]", "!"));
        fr.close();
        fw.flush();
        fw.close();
    }
}