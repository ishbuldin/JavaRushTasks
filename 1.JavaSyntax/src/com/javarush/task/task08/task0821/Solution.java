package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("Ivanov", "Anton");
        map.put("Petrov", "Anton");
        map.put("Sidorov", "Anton");
        map.put("Popov", "Anton");
        map.put("Fedorov", "Anton");
        map.put("Popkov", "Anton");
        map.put("Lopuh", "Anton");
        map.put("Arbuz", "Anton");
        map.put("Arik", "Anton");
        map.put("Ivanov", "Andrei");
        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
