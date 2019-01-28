package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String age = reader.readLine();
        String name = reader.readLine();
        int intAge = Integer.parseInt(age);
        System.out.print(name + " захватит мир через " + age + " лет. Му-ха-ха!");

        //int test = inputStreamReader.read();
        //System.out.println((char) test);
    }
}
