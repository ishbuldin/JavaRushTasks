package com.javarush.task.task25.task2512;

import java.util.Stack;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        Throwable throwable = e;
        Stack<Throwable> stack = new Stack<>();
        while (throwable != null) {
            stack.push(throwable);
            throwable = throwable.getCause();
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

    }

    public static void main(String[] args) {
        new Solution().uncaughtException(Thread.currentThread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}