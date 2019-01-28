package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        FileInputStream fis = new FileInputStream(args[0]);
        HashMap<Integer, Integer> ascii = new HashMap<>();
        for (int i = 0; i <= 127; i++) {
            ascii.put(i, 0);
        }

        while (fis.available() > 0) {
            int code = fis.read();
            if (ascii.containsKey(code)) {
                ascii.put(code, ascii.get(code) + 1);
            }
        }

        fis.close();

        for (Map.Entry<Integer, Integer> pair : ascii.entrySet()) {
            if (pair.getValue() != 0) {
                System.out.print((char)(int)pair.getKey() + " " + pair.getValue());
                System.out.println();
            }
        }
    }
}