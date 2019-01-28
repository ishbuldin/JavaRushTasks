package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(in.readLine());
        int b = Integer.parseInt(in.readLine());

        if (a>0 && b>0)
            System.out.println("1");
        else if (a<0 && b>0)
            System.out.println("2");
        else if (a<0 && b<0)
            System.out.println("3");
        else if (a>0 && b<0)
            System.out.println("4");


    }
}
