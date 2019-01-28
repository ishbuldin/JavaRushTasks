package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str  = in.readLine();
        char[] digit = str.toCharArray();
        int i = 0;
        while (i < digit.length) {
            if (digit[i] % 2 == 0)
                even++;
            else
                odd++;
            i++;
        }
        System.out.print("Even: " + even);
        System.out.print(" Odd: " + odd);
    }

}