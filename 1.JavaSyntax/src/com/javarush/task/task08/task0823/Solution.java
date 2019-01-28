package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        //напишите тут ваш код
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) //Если начало строки, делаем заглавную букву
                result += s.substring(i, i+1).toUpperCase();
            if (i > 0) {

                if (s.codePointBefore(i) == 32) //Если предыдущий код 32 (код пробела), то делаем заглавной
                    result += s.substring(i, i + 1).toUpperCase();
                else
                    result += s.substring(i, i + 1);// Иначе просто добавляем как есть
            }
        }
        System.out.println(result);
    }
}