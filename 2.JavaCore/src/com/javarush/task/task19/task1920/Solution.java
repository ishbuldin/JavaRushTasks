package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
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

        double max = 0;
        for (Map.Entry<String, Double> pair : staff.entrySet()) {
            double digit = pair.getValue();
            if(digit > max) {
                max = digit;
            }
        }
        for (Map.Entry<String, Double> pair: staff.entrySet()) {
            if (pair.getValue() == max) {
                System.out.println(pair.getKey());
            }
        }
    }
}