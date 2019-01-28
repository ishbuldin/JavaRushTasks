package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int posCount = 0;
        int negCount = 0;
        for (int i = 0; i < 3; i++) {
            int a = Integer.parseInt(in.readLine());
            if (a > 0)
                posCount++;
            else if (a < 0)
                negCount++;
        }
        System.out.println("количество отрицательных чисел: " + negCount);
        System.out.println("количество положительных чисел: " + posCount);
    }

}