package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new MyThread1());
        threads.add(new MyThread2());
        threads.add(new MyThread3());
        threads.add(new MyThread4());
        threads.add(new MyThread5());
    }

    public static void main(String[] args) {
        //for (Thread t : threads) {
        //    t.start();
        //}
        //new MyThread3().start();
        //try {
        //    MyThread4 t = new MyThread4();
        //    t.start();
        //    Thread.sleep(5000);
        //    t.showWarning();
        //}
        //catch (InterruptedException e) {
        //}
    }

    static class MyThread1 extends Thread {
        @Override
        public void run() {
            while (true) {
            }
        }
    }

    static class MyThread2 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }


    static class MyThread3 extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
                catch (InterruptedException e) {

                }
            }
        }
    }

    static class MyThread4 extends Thread implements Message {
        @Override
        public void run() {
            //try {
                while (!Thread.currentThread().isInterrupted()) {
                    //Thread.sleep(500);
                    //System.out.println("test");
                }
            //}
            //catch (InterruptedException e) {

            //}

        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    static class MyThread5 extends Thread {
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = "";
            int sum = 0;
            try {
                while (true) {
                    str = reader.readLine();
                    if (str.equals("N")) {
                        System.out.println(sum);
                        break;
                    }
                    sum = sum + Integer.parseInt(str);
                }


            }
            catch (IOException e) {

            }
        }
    }

}