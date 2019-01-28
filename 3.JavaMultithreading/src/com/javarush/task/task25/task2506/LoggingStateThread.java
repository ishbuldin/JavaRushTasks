package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread t) {
        thread = t;
    }

    @Override
    public void run() {
        Thread.State state = thread.getState();
        System.out.println(state);
        while (state != State.TERMINATED) {
            Thread.State newState = thread.getState();
            if (state != newState) {
                state = newState;
                System.out.println(state);
            }
        }
        interrupt();
    }
}