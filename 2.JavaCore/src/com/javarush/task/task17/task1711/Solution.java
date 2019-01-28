package com.javarush.task.task17.task1711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat dateFormatOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 2; i <= args.length - 2; i = i+3) {
                        if (args[i].contains("м")) {
                            allPeople.add(Person.createMale(args[i - 1], dateFormat.parse(args[i + 1])));
                        }
                        if (args[i].contains("ж")) {
                            allPeople.add(Person.createFemale(args[i - 1], dateFormat.parse(args[i + 1])));
                        }
                    }
                    int toWriteCount = (args.length - 1) / 3;
                    for (int j = toWriteCount; j > 0; j--) {
                        System.out.println(allPeople.size() - j);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i <= args.length - 4; i = i + 4) {

                        int id = Integer.parseInt(args[i]);
                        if (args[i+2].contains("м")) {
                            allPeople.get(id).setName(args[i+1]);
                            allPeople.get(id).setSex(Sex.MALE);
                            allPeople.get(id).setBirthDay(dateFormat.parse(args[i+3]));
                        }
                        if (args[i+2].contains("ж")) {
                            allPeople.get(id).setName(args[i+1]);
                            allPeople.get(id).setSex(Sex.FEMALE);
                            allPeople.get(id).setBirthDay(dateFormat.parse(args[i+3]));
                        }
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i <= args.length - 1; i++) {
                        int id = Integer.parseInt(args[i]);
                        allPeople.get(id).setName(null);
                        allPeople.get(id).setSex(null);
                        allPeople.get(id).setBirthDay(null);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i <= args.length - 1; i++) {
                        int id = Integer.parseInt(args[i]);
                        if (allPeople.get(id).getSex() == Sex.FEMALE) {
                            System.out.println(allPeople.get(id).getName() + " " + "ж " + dateFormatOut.format(allPeople.get(id).getBirthDay()));
                        }
                        if (allPeople.get(id).getSex() == Sex.MALE) {
                            System.out.println(allPeople.get(id).getName() + " " + "м " + dateFormatOut.format(allPeople.get(id).getBirthDay()));
                        }
                    }
                }
                break;
        }
    }
}