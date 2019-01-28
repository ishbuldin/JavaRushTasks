package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(in.readLine());
        int b = Integer.parseInt(in.readLine());
        int c = Integer.parseInt(in.readLine());
        int d = Integer.parseInt(in.readLine());
        System.out.println(compare(compare(a,b),compare(c,d)));

    }
    private static int compare(int a, int b) {
        if (a>b)
            return a;
        else
            return b;
    }
}
