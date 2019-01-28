package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код

        ArrayList<String> list = new ArrayList<String>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //System.out.println("Введите число N");
        int n = Integer.parseInt(in.readLine());
        //System.out.println("Введите число M");
        int m = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            list.add(in.readLine());
        }
        for (int i = 0; i < m; i++) {
            list.add(list.get(0));
            list.remove(0);
        }
        for (String a : list) {
            System.out.println(a);
        }
    }
}