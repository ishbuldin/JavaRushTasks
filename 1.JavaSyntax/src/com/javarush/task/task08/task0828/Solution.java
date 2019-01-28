package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        Calendar calendar = new GregorianCalendar(2000, 0,1);
        for (int i = 1; i <= 12; i++) {
            map.put(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH), i);
            calendar.add(Calendar.MONTH, 1);
        }
        String month = reader.readLine();
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            if (pair.getKey().equals(month)) {
                System.out.println(pair.getKey() + " is " + pair.getValue() + " month");
            }
        }
    }
}