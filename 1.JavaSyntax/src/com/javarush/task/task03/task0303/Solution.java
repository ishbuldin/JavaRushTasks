package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertEurToUsd(60, 0.8));
        System.out.println(convertEurToUsd(60, 1.2));
        //напишите тут ваш код
    }

    public static double convertEurToUsd(int eur, double course) {
        double usd;
        usd = eur * course;
        return usd;
        //напишите тут ваш код
    }
}
