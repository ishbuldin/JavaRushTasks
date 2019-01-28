package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a;
        int b;
        int maxDelimeter;

        a = Integer.parseInt(reader.readLine());
        if (a <= 0) throw new ArithmeticException();
        b = Integer.parseInt(reader.readLine());
        if (b <= 0) throw new ArithmeticException();


        maxDelimeter = (a < b) ? a : b;
        int delimeter = 1;

        for (int i = 1; i <= maxDelimeter ; i++) {
            if (a % i == 0 && b % i == 0) {
                if (i >= delimeter) {
                    delimeter = i;
                }
            }
        }
        System.out.println(delimeter);
    }
}
