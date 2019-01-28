package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] intArray = new int[10];
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        for (int i = intArray.length - 1; i >= 0; i--) {
            intArray[i] = Integer.parseInt(in.readLine());
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
}

