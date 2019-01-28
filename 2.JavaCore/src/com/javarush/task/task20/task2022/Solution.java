package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(this.fileName, true);
        //in.close();
}

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
        Solution solution = new Solution("D:/1.txt");
        solution.writeObject("test");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/2.txt"));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/2.txt"));
        oos.writeObject(solution);
        Solution solutionDes = new Solution("D:/3.txt");
        solutionDes = (Solution) ois.readObject();
        solutionDes.writeObject("test");
    }
}