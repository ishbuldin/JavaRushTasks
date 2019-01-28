package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> ints = new ArrayList<>();
        ArrayList<Character> list = new ArrayList<>();

        try {
            FileInputStream fileInputStream = new FileInputStream(reader.readLine());
            while (fileInputStream.available() > 0) {
                list.add((char)fileInputStream.read());
            }
            fileInputStream.close();
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String str = "";
        for (Character a : list) {
            str += String.valueOf(a);
        }
        String[] strings = str.split(System.lineSeparator());
        //System.out.println(Arrays.toString(strings));
        for (String s : strings) {
            ints.add(Integer.parseInt(s));
        }
        //сортировка
        for (int i = ints.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (ints.get(j) > ints.get(j+1)) {
                    int tmp = ints.get(j);
                    ints.set(j, ints.get(j+1));
                    ints.set(j+1, tmp);
                }
            }
        }
        for (int a : ints) {
            if (a % 2 == 0) {
                System.out.println(a);
            }
        }
    }
}
