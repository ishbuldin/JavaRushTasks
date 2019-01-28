package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            list.add(reader.readLine());
            if (list.get(i).equals("end")) {
                list.remove(i);
                break;
            }
            else i++;
        }
        for (String a : list) {
            System.out.println(a);
        }
    }
}