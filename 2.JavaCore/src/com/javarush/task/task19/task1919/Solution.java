package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String fileName = args[0];
        TreeMap<String, Double> staff = new TreeMap<>();
        BufferedReader fr = new BufferedReader(new FileReader(fileName));
        String line = null;
        while ((line = fr.readLine()) != null) {
            String[] strings = line.split(" ");
            String name = strings[0];
            Double salary = Double.parseDouble(strings[1]);
            if (staff.containsKey(name)) {
                staff.put(name, staff.get(name) + salary);
            }
            else {
                staff.put(name, salary);
            }
        }
        fr.close();
        for (Map.Entry<String, Double> pair : staff.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}