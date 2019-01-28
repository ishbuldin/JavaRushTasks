package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(in.readLine());
        int b = Integer.parseInt(in.readLine());
        int c = Integer.parseInt(in.readLine());
        int count = 0;
        if (moreThanZero(a))
            count++;
        if(moreThanZero(b))
            count++;
        if(moreThanZero(c))
            count++;
        System.out.println(count);

    }
    private static boolean moreThanZero(int x){
        return x>0;
    }


}
