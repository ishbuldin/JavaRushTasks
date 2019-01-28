package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String id = args[0];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fis = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        String string;
        while ((string = fis.readLine()) != null) {
            if (string.startsWith(id + " ")) {
                System.out.println(string);
            }
        }
        reader.close();
        fis.close();
    }
}
