package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String[] cmd;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat dateFormatOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        //while (true) {
        //    try {
        //        cmd = reader.readLine().split(" ");

                if (args[0].contains("-c")) {
                    if (args[2].contains("м")) {
                        allPeople.add(Person.createMale(args[1], dateFormat.parse(args[3])));
                    }
                    if (args[2].contains("ж")) {
                        allPeople.add(Person.createFemale(args[1], dateFormat.parse(args[3])));
                    }
                    System.out.println(allPeople.size() - 1);
                }

                if (args[0].contains("-u")) {
                    int id = Integer.parseInt(args[1]);
                    if (args[3].contains("м")) {
                        allPeople.get(id).setName(args[2]);
                        allPeople.get(id).setSex(Sex.MALE);
                        allPeople.get(id).setBirthDay(dateFormat.parse(args[4]));
                    }
                    if (args[3].contains("ж")) {
                        allPeople.get(id).setName(args[2]);
                        allPeople.get(id).setSex(Sex.FEMALE);
                        allPeople.get(id).setBirthDay(dateFormat.parse(args[4]));
                    }
                }

                if (args[0].contains("-d")) {
                    int id = Integer.parseInt(args[1]);
                    allPeople.get(id).setName(null);
                    allPeople.get(id).setSex(null);
                    allPeople.get(id).setBirthDay(null);
                }

                if (args[0].contains("-i")) {
                    int id = Integer.parseInt(args[1]);
                    if (allPeople.get(id).getSex() == Sex.FEMALE) {
                        System.out.println(allPeople.get(id).getName() + " " + "ж " + dateFormatOut.format(allPeople.get(id).getBirthDay()));
                    }
                    if (allPeople.get(id).getSex() == Sex.MALE) {
                        System.out.println(allPeople.get(id).getName() + " " + "м " + dateFormatOut.format(allPeople.get(id).getBirthDay()));
                    }
                }

        //    }
        //    catch (IOException e) {
        //        e.printStackTrace();
        //    }
        //    catch (ParseException e) {
        //        e.printStackTrace();
        //    }
        //}
    }
}