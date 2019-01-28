package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName = args[0];
        String zipName = args[1];
        Map<String, ByteArrayOutputStream> zipEntryArrayList = new TreeMap<>();
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipName));

        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = zis.read(buffer)) != -1) {
                baos.write(buffer, 0, count);
            }
            zipEntryArrayList.put(zipEntry.getName(), baos);
            zis.closeEntry();
            zipEntry = zis.getNextEntry();
        }
        zis.close();

        String shortFileName = fileName.substring(fileName.lastIndexOf("/") + 1);
        //System.out.println(shortFileName);

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipName));
        for (Map.Entry<String, ByteArrayOutputStream> pair : zipEntryArrayList.entrySet()) {
            if (pair.getKey().contains(shortFileName)) {
                zipEntryArrayList.remove(pair.getKey());
                //System.out.println("Removed " + pair.getKey());
            }
        }

        ZipEntry file = new ZipEntry("new/" + shortFileName);
        zos.putNextEntry(file);
        Files.copy(Paths.get(fileName), zos);
        zos.closeEntry();

        for (Map.Entry<String, ByteArrayOutputStream> pair : zipEntryArrayList.entrySet()) {
            ZipEntry ze = new ZipEntry(pair.getKey());
            zos.putNextEntry(ze);
            zos.write(pair.getValue().toByteArray());
            zos.closeEntry();
        }
        zos.close();
    }
}