package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                FileInputStream fis = new FileInputStream(line);
                fis.close();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(line);
        }
        catch (IOException e) {

        }
    }
}