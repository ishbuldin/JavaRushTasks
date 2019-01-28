package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        testString.printSomething();
        String[] result = baos.toString().split("\n");
        System.setOut(console);
        int count = 0;
        for (String string : result) {
            count++;
            if (count == 2) {
                System.out.println(string);
                System.out.println("JavaRush - курсы Java онлайн");
                count = 0;
            }
            else {
                System.out.println(string);
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}