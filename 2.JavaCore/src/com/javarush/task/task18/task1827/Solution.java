package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        if (args[0].equals("-c")) {
            BufferedReader fis = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            String line;
            int maxId = 0;
            while ((line = fis.readLine()) != null) {
                //System.out.println(line);
                String str;
                int id;
                str = line.substring(0, 8);
                Pattern pattern = Pattern.compile("[0-9]+");
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    id = Integer.parseInt(str.substring(matcher.start(), matcher.end()));
                    if (id > maxId) {
                        maxId = id;
                    }
                    //System.out.println(id);
                }
            }
            fis.close();
            BufferedWriter fos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));
            StringBuilder stringBuilder = new StringBuilder();
            if (maxId < 99999999) {
                stringBuilder.append(maxId + 1);
            }
            for (int i = 8 - stringBuilder.length(); i > 0; i--) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(args[1]);
            for (int i = 38 - stringBuilder.length(); i > 0; i--) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(args[2]);
            for (int i = 46 - stringBuilder.length(); i > 0; i--) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(args[3]);
            for (int i = 50 - stringBuilder.length(); i > 0; i--) {
                stringBuilder.append(" ");
            }
            //System.out.println(stringBuilder);
            fos.newLine();
            fos.write(stringBuilder.toString());
            fos.flush();
            fos.close();
        }
    }
}