package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), windows1251));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        String result = new String(sb.toString().getBytes(), utf8);
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(args[1]), utf8);
        osw.write(result);
        osw.close();
    }
}