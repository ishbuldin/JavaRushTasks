package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 1; i <= 10; i++) {
            map.put("Lastname" + i, "Firstname" + i);
        }
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (entry.getValue().equals(name)) {
                count++;
            }
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (entry.getKey().equals(lastName)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        /*
        HashMap<String, String> map = createMap();
        System.out.println(getCountTheSameFirstName(map,"Firstname1"));
        System.out.println(getCountTheSameLastName(map, "Lastname1"));

        for (Map.Entry<String, String> a : map.entrySet()) {
            System.out.println(a.getKey() + " - " + a.getValue());
        }

        System.out.println("");
        System.out.println("");


        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }
        */
    }
}
