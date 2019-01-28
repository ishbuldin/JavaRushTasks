package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("age", null);
        map.put(null, null);
        map.put(null, "17");

        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() != null && pair.getKey() != null) {
                result.append(pair.getKey() + " = \'" + pair.getValue() + "\' and ");
            }
        }
        if (result.toString().contains("and")) {
            return result.toString().substring(0, result.toString().lastIndexOf(" and"));
        }
        else {
            return result.toString();
        }
    }
}