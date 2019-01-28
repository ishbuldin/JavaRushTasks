package com.javarush.task.task06.task0611;

/* 
Класс StringHelper
*/

public class StringHelper {
    public static String multiply(String s) {
        String result = "";
        //напишите тут ваш код
        int i = 0;
        while (i < 5) {
            result += s;
            i++;
        }
        return result;
    }

    public static String multiply(String s, int count) {
        String result = "";
        //напишите тут ваш код
        int i = 0;
        while (i < count) {
            result += s;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {


    }
}
