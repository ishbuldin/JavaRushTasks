package com.javarush.task.task09.task0906;

/* 
Логирование стек трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        //int lastIndex = stackTraceElement.length - 1;
        int lastIndex = 2;
        System.out.println(stackTraceElement[lastIndex].getClassName() + ": " + stackTraceElement[lastIndex].getMethodName() + ": " + s);
        //напишите тут ваш код
    }
}