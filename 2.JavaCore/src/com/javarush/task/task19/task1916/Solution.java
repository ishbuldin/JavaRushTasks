package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String f1 = br.readLine();
        String f2 = br.readLine();
        //String f1 = "D:/1.txt";
        //String f2 = "D:/2.txt";
        br.close();
        BufferedReader fr1 = new BufferedReader(new FileReader(f1));
        BufferedReader fr2 = new BufferedReader(new FileReader(f2));
        List<String> file1 = new ArrayList<>();
        List<String> file2 = new ArrayList<>();
        String line1 = null;
        while ((line1 = fr1.readLine()) != null) {
            file1.add(line1);
        }
        fr1.close();
        String line2 = null;
        while ((line2 = fr2.readLine()) != null) {
            file2.add(line2);
        }
        fr2.close();
        //int max = file1.size() > file2.size() ? file1.size() : file2.size();

            for (int i = 0; i < file1.size(); i++) {
                try {
                    if (file1.get(i).equals(file2.get(0))) {
                        lines.add(new LineItem(Type.SAME, file1.get(i)));
                        file2.remove(0);
                    }
                    else if (file1.get(i).equals(file2.get(1))) {
                        lines.add(new LineItem(Type.ADDED, file2.get(0)));
                        file2.remove(0);
                        i--;
                    }
                    else {
                        lines.add(new LineItem(Type.REMOVED, file1.get(i)));
                    }
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                    if (file1.size() > file2.size())
                        lines.add(new LineItem(Type.REMOVED, file1.get(i)));
                    else
                        lines.add(new LineItem(Type.ADDED, file2.get(0)));
                }

            }
        if (file2.size() > 0)
            lines.add(new LineItem(Type.ADDED, file2.get(0)));



        for (LineItem lineItem : lines) {
            System.out.println(lineItem.type + " " + lineItem.line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}