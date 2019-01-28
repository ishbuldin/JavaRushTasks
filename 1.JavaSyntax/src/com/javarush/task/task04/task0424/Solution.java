package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(in.readLine());
        int b = Integer.parseInt(in.readLine());
        int c = Integer.parseInt(in.readLine());

        if (a!=b && b==c)
            System.out.println("1");
        else if (b!=a && a==c)
            System.out.println("2");
        else if (c!=a && a==b)
            System.out.println("3");


    }
}
