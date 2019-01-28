package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        testString.printSomething();
        String result = outputStream.toString();
        String[] numbers = new String[2];
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(result);
        int index = 0;
        int a;
        int b;
        while (m.find()) {
            numbers[index] = result.substring(m.start(), m.end());
            index++;
        }
        a = Integer.parseInt(numbers[0]);
        b = Integer.parseInt(numbers[1]);
        result = result.replaceAll("\\r|\\n", "");
        if (result.contains("+")) {
            result = result + (a + b);
        }
        if (result.contains("*")) {
            result = result + (a * b);
        }
        if (result.contains("-")) {
            result = result + (a - b);
        }
        System.setOut(console);
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}