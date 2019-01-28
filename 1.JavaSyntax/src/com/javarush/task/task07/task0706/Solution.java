package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] houses = new int[15];
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < houses.length; i++) {
            houses[i] = Integer.parseInt(in.readLine());
        }

        int env = 0;
        int odd = 0;
        for (int i = 0; i < houses.length; i++) {
            if (i == 0 || i % 2 == 0) {
                env += houses[i];
            }
            else if (i % 2 != 0) {
                odd += houses[i];
            }
        }

        if (env > odd)
            System.out.println("В домах с четными номерами проживает больше жителей.");
        else
            System.out.println("В домах с нечетными номерами проживает больше жителей.");

    }
}
