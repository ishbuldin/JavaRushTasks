package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        }
        catch (IOException e) {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут

    public static class ReadFileThread extends Thread implements ReadFileInterface {

        private String file;
        ArrayList<String> strings = new ArrayList<>();

        @Override
        public void setFileName(String fullFileName) {
            this.file = fullFileName;
        }

        @Override
        public String getFileContent() {
            String result = "";
            for (String string : strings) {
                result += string + " ";
            }
            return result;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(this.file));
                while (true) {
                    String string = reader.readLine();
                    if (string != null) {
                        strings.add(string);
                    }
                    else {
                        break;
                    }
                }
            }
            catch (IOException e) {

            }
        }
    }
}