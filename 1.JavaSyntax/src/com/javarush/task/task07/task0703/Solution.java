package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String[] strArrsy = new String[10];
        int[] intArray = new int[10];
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < strArrsy.length; i++) {
            strArrsy[i] = in.readLine();
            intArray[i] = strArrsy[i].length();
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }

    }
}
