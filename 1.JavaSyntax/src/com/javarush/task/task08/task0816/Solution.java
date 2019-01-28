package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Swarc", new Date(1989, 1, 17));
        map.put("Ivanov", new Date(1989, 2, 22));
        map.put("Petrov", new Date(1989, 3, 8));
        map.put("Sidorov", new Date(1989, 4, 4));
        map.put("Pupkin", new Date(1989, 5, 2));
        map.put("Popov", new Date(1989, 6, 1));
        map.put("Fedorov", new Date(1989, 7, 12));
        map.put("Popkov", new Date(1989, 8, 19));
        map.put("Vaskin", new Date(1989, 9, 13));
        return map;
        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> entry = iterator.next();
            if (entry.getValue().getMonth() == 5 || entry.getValue().getMonth() == 6 || entry.getValue().getMonth() == 7) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {

        /*
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);

        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> entry = iterator.next();
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }
        */
    }
}