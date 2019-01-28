package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String resultFileName = args[0];
        ArrayList<String> fileNamePart = new ArrayList<>();
        Vector<InputStream> fileNamePartVector = new Vector<>();
        int index = 1;
        while (index < args.length) {
            fileNamePart.add(args[index]);
            index++;
        }
        Collections.sort(fileNamePart);
        for (String s : fileNamePart) {
            fileNamePartVector.add(new FileInputStream(s));
        }

        ZipInputStream zis = new ZipInputStream(new SequenceInputStream(fileNamePartVector.elements()));
        FileOutputStream fos = new FileOutputStream(resultFileName);
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
                fos.flush();
            }
            zis.closeEntry();
            zipEntry = zis.getNextEntry();
        }
        zis.close();
        fos.close();
    }
}