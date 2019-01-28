package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Date date = new Date(reader.readLine());

        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(new Locale("en"));
        String[] months = dateFormatSymbols.getShortMonths();
        for (int i = 0; i < months.length; i++) {
            months[i] = months[i].toUpperCase();
        }

        dateFormatSymbols.setShortMonths(months);


        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy", dateFormatSymbols);
        System.out.println(dateFormat.format(date));
    }
}