package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        double minute = Double.parseDouble(in.readLine());
        if (minute%5<3)
            System.out.println("зелёный");
        else if (minute%5>=3 && minute%5<4)
            System.out.println("желтый");
        else if (minute%5>=4 && minute%5<5)
            System.out.println("красный");
    }
}