package com.javarush.task.task14.task1419;

import org.w3c.dom.events.EventException;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {
            int[] ints = new int[0];
            ints[0] = 1;
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            ArrayList<Integer> list = new ArrayList<>();
            int i = list.get(0);
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String str = null;
            if (str.equals("test")) {
                System.out.println("test");
            }
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Object x[] = new String[3];
            x[0] = new Integer(0);
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Object x = new Integer(0);
            System.out.println((String)x);
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] ints = new int[-10];
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new SecurityException();
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new EmptyStackException();
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new BufferOverflowException();
        }
        catch (Exception e) {
            exceptions.add(e);
        }
    }
}
