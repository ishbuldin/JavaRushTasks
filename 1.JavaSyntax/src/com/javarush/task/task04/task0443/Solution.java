package com.javarush.task.task04.task0443;


/* 
Как назвали, так назвали
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String name = in.readLine();
        int y = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());
        int d = Integer.parseInt(in.readLine());
        System.out.println("Меня зовут " + name + "." + "\n"
                + "Я родился " + d + "." + m + "." + y);
    }
}
