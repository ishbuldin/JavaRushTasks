package com.javarush.task.task28.task2805;

public class MyThread extends Thread {
    private static int prior = 1;

    {
        if (prior <= MAX_PRIORITY) {
            this.setPriority(prior);
            prior++;
        }
        else {
            prior = 1;
            this.setPriority(prior);
            prior++;
        }
    }

    public MyThread() {

    }

    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }
}
