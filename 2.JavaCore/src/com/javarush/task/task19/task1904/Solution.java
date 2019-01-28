package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        //PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(new Scanner(new FileReader("D:/1.txt")));
        //Person person = personScannerAdapter.read();
        //System.out.println(person);
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;
        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] string = fileScanner.nextLine().split(" ");
            //for (String s : string)
            //    System.out.println(s);
            int year = Integer.parseInt(string[5]);
            int month = Integer.parseInt(string[4]) - 1;
            int day = Integer.parseInt(string[3]);
            return new Person(string[1], string[2], string[0], new GregorianCalendar(year, month, day).getTime());
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}