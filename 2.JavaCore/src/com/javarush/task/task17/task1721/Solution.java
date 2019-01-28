package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String filename1 = reader.readLine();
            String filename2 = reader.readLine();
            BufferedReader fr1 = new BufferedReader(new FileReader(filename1));
            BufferedReader fr2 = new BufferedReader(new FileReader(filename2));
            String line;
            while ((line = fr1.readLine()) != null) {
                allLines.add(line);
            }
            while ((line = fr2.readLine()) != null) {
                forRemoveLines.add(line);
            }
            reader.close();
            fr1.close();
            fr2.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Solution solution = new Solution();
        try {
            solution.joinData();
        }
        catch (CorruptedDataException e) {
            e.printStackTrace();
        }

    }

    public void joinData () throws CorruptedDataException {

        int size = forRemoveLines.size();
        int count = 0;
        for (String forRemove : forRemoveLines) {
            for (String all : allLines) {
                if (all.equals(forRemove)) {
                    count++;
                }
            }
        }
        //System.out.println(allLines);
        //System.out.println(forRemoveLines);
        if (size == count) {
            allLines.removeAll(forRemoveLines);
            //System.out.println(allLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}