package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
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
        Collection<Integer> values = bytes.values();
        ArrayList<Integer> sortedValues = new ArrayList<>(values);
        Collections.sort(sortedValues);
        for (HashMap.Entry<Integer, Integer> pair : bytes.entrySet()) {
            if (pair.getValue().equals(sortedValues.get(sortedValues.size() - 1))) {
                System.out.print(pair.getKey() + " ");
            }
        }
    }
}