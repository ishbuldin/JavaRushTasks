package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            String line = reader.readLine();
            if ("exit".equals(line))
                break;
            else {
                if (line.contains(".") && isDouble(line)) {
                    print(Double.parseDouble(line));
                }
                else if (isInteger(line)) {
                    if (Integer.parseInt(line) > 0 && Integer.parseInt(line) < 128)
                        print(Short.parseShort(line));
                    else if (Integer.parseInt(line) <= 0 || Integer.parseInt(line) >=128) {
                        print(Integer.parseInt(line));
                    }
                }
                else
                print(line);
            }
        }
        while(true);

    }

    public static boolean isDouble(String string) {
        if (string == null)
            return false;
        else {
            try {
                Double.parseDouble(string);
                return true;
            }
            catch (Exception e) {
                return false;
            }
        }
    }

    public static boolean isInteger(String string) {
        if (string == null)
            return false;
        else {
            try {
                Integer.parseInt(string);
                return true;
            }
            catch (Exception e) {
                return false;
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
