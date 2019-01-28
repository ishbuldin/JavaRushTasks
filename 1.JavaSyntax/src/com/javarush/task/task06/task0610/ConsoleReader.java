package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        //напишите тут ваш код
        String str;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        str = in.readLine();
        return str;
    }

    public static int readInt() throws Exception {
        //напишите тут ваш код
        int intNum;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        intNum = Integer.parseInt(in.readLine());
        return intNum;
    }

    public static double readDouble() throws Exception {
        //напишите тут ваш код
        double doubleNum;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        doubleNum = Double.parseDouble(in.readLine());
        return doubleNum;
    }

    public static boolean readBoolean() throws Exception {
        //напишите тут ваш код
        boolean b;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        b = Boolean.parseBoolean(in.readLine());
        return b;
    }

    public static void main(String[] args) {

    }
}
