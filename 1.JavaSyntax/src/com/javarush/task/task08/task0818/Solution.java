package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            map.put("Lastname" + i, random.nextInt(1000));
        }
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> pair = iterator.next();
            if (pair.getValue() < 500) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = createMap();
        //for (Map.Entry<String, Integer> a : map.entrySet()) {
        //    System.out.println(a.getKey() + " - " + a.getValue());
        //}
        removeItemFromMap(map);
        //System.out.println("------------------");
        //for (Map.Entry<String, Integer> a : map.entrySet()) {
        //    System.out.println(a.getKey() + " - " + a.getValue());
        //}

    }
}