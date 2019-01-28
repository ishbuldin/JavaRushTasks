package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Ivanov1", "Sasha");
        map.put("Ivanov2", "1");
        map.put("Ivanov3", "1");
        map.put("Ivanov4", "Sasha");
        map.put("Ivanov5", "Kirill");
        map.put("Ivanov6", "Petya");
        map.put("Ivanov7", "Vova");
        map.put("Ivanov8", "Maxim");
        map.put("Ivanov9", "Bobik");
        map.put("Ivanov10", "Vadik");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        HashMap<String, String> copyMap1 = new HashMap<String, String>(map);
        HashMap<String, String> copyMap2 = new HashMap<String, String>(map);

        Iterator<Map.Entry<String, String>> iterator1 = copyMap1.entrySet().iterator();
        while (iterator1.hasNext()) {
            Iterator<Map.Entry<String, String>> iterator2 = copyMap1.entrySet().iterator();
            Map.Entry<String, String> pair1 = iterator1.next();
            String value1 = pair1.getValue();
            String key1 = pair1.getKey();
            //System.out.println("key1 " + key1 + "value1 " + value1);
            while (iterator2.hasNext()) {
                //System.out.println("-------------------");
                Map.Entry<String, String> pair2 = iterator2.next();
                String value2 = pair2.getValue();
                String key2 = pair2.getKey();
                //System.out.println("key2 " + key2 + "value2 " + value2);
                if (value1.equals(value2) && !key1.equals(key2)) {
                //    System.out.println("true");
                    removeItemFromMapByValue(map,value1);
                }
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
        //for (Map.Entry<String, String> a : map.entrySet()) {
        //    System.out.println(a.getKey() + " - " + a.getValue());
        //}
    }
}