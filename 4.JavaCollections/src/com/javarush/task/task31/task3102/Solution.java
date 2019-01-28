package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        ArrayDeque<String> folders = new ArrayDeque<>();
        List<String> files = new ArrayList<>();
        folders.add(root);
        while (!folders.isEmpty()) {
            File folder = new File(folders.pollLast());
            for(File file : folder.listFiles()) {
                if (file.isDirectory()) {
                    folders.add(file.getAbsolutePath());
                }
                else files.add(file.getAbsolutePath());
            }
        }
        return files;
    }

    public static void main(String[] args) throws IOException {
        //List<String> list;
        //list = getFileTree("D:/TEST");
        //for (String string : list)
        //    System.out.println(string);
    }
}