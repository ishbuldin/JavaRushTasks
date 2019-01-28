package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //dayOfWeek(Integer.parseInt(in.readLine()));
        int b = Integer.parseInt(in.readLine());
        //напишите тут ваш код

        if(b == 1) System.out.print("понедельник");
        else if (b == 2) System.out.println("вторник");
        else if (b == 3) System.out.println("среда");
        else if (b == 4) System.out.println("четверг");
        else if (b == 5) System.out.println("пятница");
        else if (b == 6) System.out.println("суббота");
        else if (b == 7) System.out.println("воскресенье");
        else System.out.println("такого дня недели не существует");

    }
/*    private static void dayOfWeek(int n) {
        switch (n) {
            default:
                System.out.println("такого дня недели не существует");
            case 1:
                System.out.println("понедельник");
                break;
            case 2:
                System.out.println("вторник");
                break;
            case 3:
                System.out.println("среда");
                break;
            case 4:
                System.out.println("четверг");
                break;
            case 5:
                System.out.println("пятница");
                break;
            case 6:
                System.out.println("суббота");
                break;
            case 7:
                System.out.println("воскресенье");
                break;
        }
    }
*/
}