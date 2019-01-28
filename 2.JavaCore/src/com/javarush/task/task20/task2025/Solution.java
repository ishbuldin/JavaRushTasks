package com.javarush.task.task20.task2025;


import java.util.ArrayList;
import java.util.Date;

/*
Алгоритмы-числа
*/
public class Solution {

    private static long[][] pows = new long[10][19];

    static {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 19; j++) {
                pows[i][j] = (long) Math.pow((double) i, (double) j);
            }
        }
    }

    public static long[] getNumbers(long N) {
        long[] result = null;
        long number = 1;
        ArrayList<Long> list = new ArrayList<>();
        while (number < N) {
            String digits = String.valueOf(number);
            int pow = digits.length();
            long match = 0;
            for (int i = 0; i < pow; i++) {
                byte digit = Byte.parseByte(digits.substring(i, i+1));
                match += pows[digit][pow];
                if (match > number)
                    break;
            }
            if (number == match) {
                list.add(number);
                System.out.println(number);
            }
            number++;
        }
        result = new long[list.size()];
        int index = 0;
        for (Long l : list) {
            result[index] = l;
        }
        return result;
    }


    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        long memStart = runtime.totalMemory() - runtime.freeMemory();
        Date startTime = new Date();
        getNumbers(99999999);
        long memStop = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory: " + (memStop - memStart) / 1024);
        Date endTime = new Date();
        System.out.println("Time: " + (endTime.getTime() - startTime.getTime()));
    }
}