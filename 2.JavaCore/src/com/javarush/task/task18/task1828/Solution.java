package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        if (args[0].equals("-u")) {
            BufferedReader fis = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            String line;
            int id = Integer.parseInt(args[1]);
            while ((line = fis.readLine()) != null) {
                String str;
                int idFromFile;
                str = line.substring(0, 8);
                Pattern pattern = Pattern.compile("[0-9]+");
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    idFromFile = Integer.parseInt(str.substring(matcher.start(), matcher.end()));
                    if (id == idFromFile) {
                        strings.add(String.format("%-8d%-30s%-8s%-4s", id, args[2], args[3], args[4]));
                    }
                    else {
                        strings.add(line);
                    }
                }
            }
            fis.close();
            BufferedWriter fos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
            for (String string : strings) {
                fos.write(string);
                fos.newLine();
            }
            fos.flush();
            fos.close();
        }
        if(args[0].equals("-d")) {
            BufferedReader fis = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            String line;
            int id = Integer.parseInt(args[1]);
            while ((line = fis.readLine()) != null) {
                String str;
                int idFromFile;
                str = line.substring(0, 8);
                Pattern pattern = Pattern.compile("[0-9]+");
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    idFromFile = Integer.parseInt(str.substring(matcher.start(), matcher.end()));
                    if (id != idFromFile) {
                        strings.add(line);
                    }
                }
            }
            fis.close();
            BufferedWriter fos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
            for (String string : strings) {
                fos.write(string);
                fos.newLine();
            }
            fos.flush();
            fos.close();
        }
    }
}