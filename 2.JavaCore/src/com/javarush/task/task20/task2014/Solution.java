package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        System.out.println(new Solution(4));
        try {
            OutputStream outputStream = new FileOutputStream("D:/1.txt");
            InputStream inputStream = new FileInputStream("D:/1.txt");
            Solution solution = new Solution(22);
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            oos.writeObject(solution);
            Solution solutionFromFile = new Solution(18);
            solutionFromFile = (Solution) ois.readObject();
            System.out.println(solution.string.equals(solutionFromFile.string));
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}