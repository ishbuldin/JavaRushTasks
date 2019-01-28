package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        // создай и заполни массив
        int[] intArray = new int[20];
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            intArray[i] = Integer.parseInt(in.readLine());
        }
        return intArray;
    }

    public static int max(int[] array) {
        // найди максимальное значение
        int maximum = array[0];
        for (int i = 0; i < array.length; i++) {
            if (maximum < array[i]) {
                maximum = array[i];
            }
        }
        return maximum;
    }
}
