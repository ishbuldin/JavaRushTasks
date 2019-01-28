package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        Pattern namePattern = Pattern.compile("[^\\d+]");
        Pattern datePattern = Pattern.compile("[ ][0-9]+");
        Matcher m;
        String line = null;
        while ((line = br.readLine()) != null) {
            String name = "";
            String bd = "";
            String[] dates;
            m = namePattern.matcher(line);
            while (m.find()) {
                name += line.substring(m.start(), m.end());
            }
            name = name.trim();
            m = datePattern.matcher(line);
            while (m.find()) {
                bd += line.substring(m.start(), m.end());
            }
            bd = bd.trim();
            dates = bd.split(" ");
            int year = Integer.parseInt(dates[2]);
            int month = Integer.parseInt(dates[1]) - 1;
            int day = Integer.parseInt(dates[0]);
            PEOPLE.add(new Person(name, new GregorianCalendar(year, month, day).getTime()));
        }
        br.close();
        //SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        //for (Person p : PEOPLE) {
        //    System.out.println(sdf.format(p.getBirthday()) + " " + p.getName());
        //}
    }
}
