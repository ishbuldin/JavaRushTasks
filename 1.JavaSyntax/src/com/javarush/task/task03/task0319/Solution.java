package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String name = bufferedReader.readLine();
        String salary = bufferedReader.readLine();
        String age2 = bufferedReader.readLine();
        System.out.println(name + " получает " + salary + " через " + age2 + " лет.");
    }
}
