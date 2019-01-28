package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        HashMap<Integer, Integer> bytes = new HashMap<>();
        while (fileInputStream.available() > 0) {
            int fromFile = fileInputStream.read();
            if (bytes.containsKey(fromFile)) {
                bytes.put(fromFile, bytes.get(fromFile) + 1);
            }
            else {
                bytes.put(fromFile, 1);
            }
        }
        reader.close();
        fileInputStream.close();
        Collection<Integer> keys = bytes.keySet();
        ArrayList<Integer> sortedValues = new ArrayList<>(keys);
        Collections.sort(sortedValues);

        for (int a : sortedValues) {
            System.out.print(a + " ");
        }

    }
}
