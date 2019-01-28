package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/*
Проход по дереву файлов
*/
public class Solution {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File folder = new File(args[0]);
        File firstFile = new File(args[1]);
        File secondFile = new File(firstFile.getParent() + "/allFilesContent.txt");
        if (FileUtils.isExist(firstFile)) {
            FileUtils.renameFile(firstFile, secondFile);
        }
        FileOutputStream fos = new FileOutputStream(secondFile, true);

        Solution solution = new Solution();
        TreeMap<String, File> fileTreeMap;
        fileTreeMap = solution.getFiles(folder);
        for (Map.Entry<String, File> pair : fileTreeMap.entrySet()) {
            //System.out.println(pair.getKey());
            FileInputStream fis = new FileInputStream(pair.getValue());
            while (fis.available() > 0) {
                fos.write(fis.read());
            }
            fos.write("\n".getBytes());
            fis.close();
            fos.flush();
        }
        fos.close();
    }

    private TreeMap<String, File> getFiles(File folder) {
        TreeMap<String, File> files = new TreeMap<>();
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                files.putAll(getFiles(file));
            }
            else {
                if (file.length() <= 50)
                files.put(file.getName(), file);
            }
        }
        return files;
    }
}