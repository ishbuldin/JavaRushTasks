package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int buf = 0;
        while (true) {
            int a = Integer.parseInt(in.readLine());
            buf += a;
            if (a == -1) {
                System.out.println(buf);
                break;
            }

        }

    }
}
