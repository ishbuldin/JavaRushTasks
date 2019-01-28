package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        br.close();
        FileReader fr = new FileReader(fileName1);
        FileWriter fw = new FileWriter(fileName2);
        int count = 0;
        while (fr.ready()) {
            int a = fr.read();
            count++;
            if (count % 2 == 0) {
                fw.write(a);
            }
        }
        fr.close();
        fw.close();
    }
}
