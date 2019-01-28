package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        compare(Integer.parseInt(in.readLine()));
    }

    private static void compare(int digit) {
        if(digit<0)
            System.out.println(digit+1);
        else if(digit==0)
            System.out.println(digit);
        else
            System.out.println(digit*2);
    }

}