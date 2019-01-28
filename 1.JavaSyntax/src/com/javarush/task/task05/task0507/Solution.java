package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        float sum = 0;
        int count = 0;
        while (true) {
            float temp = Float.parseFloat(in.readLine());
            if (temp == -1)
                break;
            sum += temp;
            count++;
        }
        float average = sum/count;
        System.out.println(average);
    }
}

