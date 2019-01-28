package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        int x = Integer.parseInt(in.readLine());
        int i = 0;
        while(i < x) {
            System.out.println(s);
            i++;
        }

    }
}
