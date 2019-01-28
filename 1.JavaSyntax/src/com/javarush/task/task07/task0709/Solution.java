package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код


        ArrayList<String> list = new ArrayList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            list.add(in.readLine());
        }

        int minLen = list.get(0).length();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() <= minLen) {
                minLen = list.get(i).length();
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == minLen) {
                System.out.println(list.get(i));
            }
        }
    }
}
