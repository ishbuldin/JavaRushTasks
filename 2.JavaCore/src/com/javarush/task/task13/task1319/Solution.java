package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String filename = reader.readLine();
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            while (true) {
                String str = reader.readLine();
                writer.write(str + System.lineSeparator());
                if (str.equals("exit")) {
                    break;
                }
            }
            reader.close();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
