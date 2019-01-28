package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(in.readLine());
        if (x <= 999 && x >= 1) {
            if (x / 100 >= 1) {
                if (x % 2 == 0)
                    System.out.println("четное трехзначное число");
                else
                    System.out.println("нечетное трехзначное число");
            } else if (x / 10 >= 1) {
                if (x % 2 == 0)
                    System.out.println("четное двузначное число");
                else
                    System.out.println("нечетное двузначное число");
            } else if (x / 10 < 1) {
                if (x % 2 == 0)
                    System.out.println("четное однозначное число");
                else
                    System.out.println("нечетное однозначное число");
            }
        }

    }
}
