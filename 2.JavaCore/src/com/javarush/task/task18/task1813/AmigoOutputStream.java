package com.javarush.task.task18.task1813;

import java.io.*;
import java.nio.channels.FileChannel;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    //public static String fileName = "D:/1.txt";
    private FileOutputStream fileOutputStream;

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException, IOException {
        super(fileOutputStream.getFD());
        //super(fileName);
        this.fileOutputStream = fileOutputStream;
    }

    @Override
    public void write(int b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fileOutputStream.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.flush();
        String data = "JavaRush © All rights reserved.";
        fileOutputStream.write(data.getBytes());
        fileOutputStream.close();
    }

    @Override
    public FileChannel getChannel() {
        return fileOutputStream.getChannel();
    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
