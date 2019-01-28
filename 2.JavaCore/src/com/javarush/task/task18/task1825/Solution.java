package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> fileNames = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        while (!(fileName = bufferedReader.readLine()).equals("end")) {
            fileNames.add(fileName);
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                Pattern p = Pattern.compile(".part[0-9]+");
                Matcher m1 = p.matcher(o1);
                Matcher m2 = p.matcher(o2);
                int index1 = -1;
                int index2 = -1;
                if (m1.find()) {
                    index1 = Integer.parseInt(o1.substring(m1.start() + 5, m1.end()));
                }
                if (m2.find()) {
                    index2 = Integer.parseInt(o2.substring(m2.start() + 5, m2.end()));
                }
                return index1 - index2;
            }
        };
        fileNames.sort(comparator);
        //System.out.println(fileNames);
        FileOutputStream fos = new FileOutputStream(fileNames.get(0).split(".part")[0], true);

        for (String file : fileNames) {
            //System.out.println(file);
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[fis.available()];
            if (fis.available() > 0) {
                fis.read(buffer, 0, buffer.length);
            }
            fis.close();
            fos.write(buffer);
        }
        fos.close();
    }
}