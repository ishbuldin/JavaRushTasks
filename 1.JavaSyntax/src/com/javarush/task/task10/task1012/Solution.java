package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        HashMap<Character, Integer> alphabetCounter = new HashMap<>();
        for (Character a : alphabet) {
            alphabetCounter.put(a, 0);
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                if (isEqual(list.get(i).charAt(j), abcArray)) {
                    int count = alphabetCounter.get(list.get(i).charAt(j)) + 1;
                    alphabetCounter.put(list.get(i).charAt(j), count);
                }
            }
        }
        //for (Map.Entry<Character, Integer> entry : alphabetCounter.entrySet()) {
         //   System.out.println(entry.getKey() + " " + entry.getValue());
        //}

        for (int i = 0; i < abcArray.length; i++) {
            System.out.println(abcArray[i] + " " + alphabetCounter.get(abcArray[i]));
        }

    }

    public static boolean isEqual (char c, char[] abc) {

        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : abc)   // ищем среди алфавита
        {
            if (c == d)
                return true;
        }
        return false;
    }

}
