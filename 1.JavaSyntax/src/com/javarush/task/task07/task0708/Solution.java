package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            list.add(in.readLine());
        }
        int maxLen = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > maxLen) {
                maxLen = list.get(i).length();
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == maxLen) {
                System.out.println(list.get(i));
            }
        }
    }
}
