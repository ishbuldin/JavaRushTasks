package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        int[] intArrayBig = new int[20];
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < intArrayBig.length; i++) {
            intArrayBig[i] = Integer.parseInt(in.readLine());
        }
        int[] intArraySmall1 = new int[10];
        int[] intArraySmall2 = new int[10];
        for (int i = 0; i < intArrayBig.length; i++) {
            if (i < 10) {
                intArraySmall1[i] = intArrayBig[i];
            }
            else if (i >= 10) {
                intArraySmall2[i-10] = intArrayBig[i];
            }
        }
        for (int i = 0; i < intArraySmall2.length; i++) {
            System.out.println(intArraySmall2[i]);
        }
    }
}
