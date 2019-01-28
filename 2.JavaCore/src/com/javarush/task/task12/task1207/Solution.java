package com.javarush.task.task12.task1207;

/* 
Int и Integer
*/

public class Solution {
    public static void main(String[] args) {
        int a = 1;
        Integer b = 1;
        print(a);
        print(b);
    }

    //Напишите тут ваши методы
    public static void print(Integer i) {
        System.out.println("Integer");
    }
    public static void print(int i) {
        System.out.println("int");
    }
}