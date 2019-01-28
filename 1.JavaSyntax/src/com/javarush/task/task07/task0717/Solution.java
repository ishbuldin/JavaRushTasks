package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Считать строки с консоли и объявить ArrayList list тут
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(in.readLine());
        }
        ArrayList<String> result = doubleValues(list);
        // Вывести на экран result
        for (String a : result)
            System.out.println(a);
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        //напишите тут ваш код
        /*
        for (int i = 0; i < list.size(); i++) {
            String temp = "";
            for (int j = 0; j < list.get(i).length(); j++) {
                temp += list.get(i).substring(j,j+1);
                temp += list.get(i).substring(j,j+1);
            }
            list.remove(i);
            list.add(i, temp);
        }
        */

        for (int i = 0; i < list.size(); i+=2) {
            list.add(i, list.get(i));
        }
        return list;
    }
}