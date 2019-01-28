package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String strVowels = "";
        String strOther = "";

        char[] strChar = str.toCharArray();
        for (char c : strChar) {
            if (isVowel(c))
                strVowels += c + " ";
            else {
                if (c == " ".charAt(0))
                    strOther = strOther;
                else
                    strOther += c + " ";
            }
        }
        System.out.println(strVowels);
        System.out.println(strOther);
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}