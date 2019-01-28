package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        ArrayList<String> listNew = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str.length() % 2 == 0) {
                str += " " + str;
                listNew.add(str);
            }
            else {
                String tempStr = str;
                str += " " + tempStr;
                str += " " + tempStr;
                listNew.add(str);
            }
        }

        for (int i = 0; i < listNew.size(); i++) {
            System.out.println(listNew.get(i));
        }
    }
}
