package com.javarush.task.task20.task2015;

import java.io.*;

/* 
Переопределение сериализации
*/
public class Solution implements Serializable, Runnable {
    private transient Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, does not matter
        try {
            int count = 0;
            while (count <= speed) {
                System.out.println("current speed = " + speed);
                speed--;
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException, InterruptedException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        runner = new Thread(this);
        runner.start();
}

    public static void main(String[] args) {
        try {
            Solution solution = new Solution(5);
            Thread.sleep(2000);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/1.txt"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/1.txt"));
            oos.writeObject(solution);
            System.out.println("wait 7 seconds");
            Thread.sleep(7000);
            solution = (Solution) ois.readObject();
            System.out.println("SPEED = " + solution.speed);
        }
        catch (InterruptedException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}