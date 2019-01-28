package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(in.readLine());
        int b = Integer.parseInt(in.readLine());
        int c = Integer.parseInt(in.readLine());

        if (a <= b && a >= c || a >= b && a <= c)
            System.out.println(a);
        else if (b <= a && b >= c || b >= a && b <= c)
            System.out.println(b);
        else if (c <= a && c >= b || c >= a && c <= b)
            System.out.println(c);
        else if (a == b || a == c)
            System.out.println(a);
        else if (b == c)
            System.out.println(b);

    }
}
