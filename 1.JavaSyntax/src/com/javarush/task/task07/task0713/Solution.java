package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> listDiv3 = new ArrayList<Integer>();
        ArrayList<Integer> listDiv2 = new ArrayList<Integer>();
        ArrayList<Integer> listOther = new ArrayList<Integer>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 20; i++) {
            list.add(Integer.parseInt(in.readLine()));
        }

        for (int i = 0; i < list.size(); i++){
            if (list.get(i) % 2 == 0 && list.get(i) % 3 == 0) {
                listDiv2.add(list.get(i));
                listDiv3.add(list.get(i));
            }
            else if (list.get(i) % 2 == 0) {
                listDiv2.add(list.get(i));
            }
            else if (list.get(i) % 3 == 0) {
                listDiv3.add(list.get(i));
            }
            else {
                listOther.add(list.get(i));
            }
        }
        printList(listDiv3);
        printList(listDiv2);
        printList(listOther);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (Integer a : list)
            System.out.println(a);
    }
}