package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
        //напишите тут ваш код
        return a + b;
    }

    public static int minus(int a, int b) {
        //напишите тут ваш код
        return a - b;
    }

    public static int multiply(int a, int b) {
        //напишите тут ваш код
        return a * b;
    }

    public static double division(int a, int b) {
        //напишите тут ваш код
        double x = a;
        double y = b;
        return x / y;
    }

    public static double percent(int a, int b) {
        //напишите тут ваш код
        double x = a;
        double y = b;
        return  y / 100 * x;
    }

    public static void main(String[] args) {

        System.out.println(Calculator.percent(200,40));
        System.out.println(Calculator.division(1,2));

    }
}