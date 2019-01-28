package com.javarush.task.task06.task0613;

/* 
Кот и статика
*/

public class Solution {
    public static void main(String[] args) {
        //создай 10 котов
        int i = 0;
        while (i < 10){
            Cat cat = new Cat();
            i++;
        }
        System.out.println(Cat.catCount);

        //выведи значение переменной catCount
    }

    public static class Cat {
        //создай статическую переменную catCount
        public static int catCount;

        //создай конструктор
        public Cat() {
            catCount++;
        }
    }
}
