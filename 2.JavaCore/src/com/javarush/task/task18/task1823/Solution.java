package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename;
        while (!(filename = bufferedReader.readLine()).equals("exit")) {
            ReadThread readThread = new ReadThread(filename);
            readThread.start();
        }
        //System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            try {
                HashMap<Integer, Integer> bytes = new HashMap<>();
                FileInputStream fis = new FileInputStream(fileName);
                while (fis.available() > 0) {
                    int myByte = fis.read();
                    if (!bytes.containsKey(myByte)) {
                        bytes.put(myByte, 1);
                    }
                    else {
                        bytes.put(myByte, bytes.get(myByte) + 1 );
                    }
                }
                fis.close();
                int maxValue = 0;
                int maxKey = 0;
                for (Map.Entry<Integer, Integer> pair : bytes.entrySet()) {
                    if (pair.getValue() > maxValue) {
                        maxValue = pair.getValue();
                        maxKey = pair.getKey();
                    }
                }
                resultMap.put(fileName, maxKey);
            }
            catch (FileNotFoundException e) {

            }
            catch (IOException e) {

            }
        }
    }
}