package com.javarush.task.task19.task1908;

/* 
Выделяем числа
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
        Pattern p = Pattern.compile("^[0-9]+|\\s[0-9]+\\s|\\s[0-9]+\\z");
        Matcher m = p.matcher(sb);
        while (m.find()) {
            fw.write(sb.substring(m.start(), m.end()).trim() + " ");
        }
        fr.close();
        fw.flush();
        fw.close();
    }
}
