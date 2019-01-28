package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        //напишите тут ваш код
        int[] intArray = new int[20];
        for (int i = 0; i < 20; i++) {
            intArray[i] = Integer.parseInt(reader.readLine());
        }

        maximum = intArray[0];
        minimum = intArray[0];

        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > maximum)
                maximum = intArray[i];
            if (intArray[i] < minimum)
                minimum = intArray[i];
        }

        System.out.println(maximum);
        System.out.println(minimum);
    }
}