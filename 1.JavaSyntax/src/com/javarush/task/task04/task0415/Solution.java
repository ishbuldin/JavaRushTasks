package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;
import java.nio.Buffer;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(in.readLine());
        int b = Integer.parseInt(in.readLine());
        int c = Integer.parseInt(in.readLine());

        if(a<(b+c) && b<(a+c) && c<(a+b))
            System.out.println("Треугольник существует.");
        else
            System.out.println("Треугольник не существует.");


    }
}