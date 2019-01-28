package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
    //    for (int i = 1; i < 11; i++) {
    //        for(int j = 1; j < 11; j++) {
    //            System.out.print(i*j + " ");
    //        }
    //        System.out.println();
    //    }

        int a = 1;
        while(a < 11) {
            int b = 1;
            while (b < 11) {
                System.out.print(a*b + " ");
                b++;
            }
            System.out.println();
            a++;
        }


    }
}
