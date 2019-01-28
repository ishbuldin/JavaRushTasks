package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String[] strArray = new String[10];
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < strArray.length - 2; i++) {
            strArray[i] = in.readLine();
        }

        for (int i = strArray.length - 1; i >= 0; i--) {
            System.out.println(strArray[i]);
        }
    }
}