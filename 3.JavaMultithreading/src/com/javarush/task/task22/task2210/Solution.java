package com.javarush.task.task22.task2210;

import java.util.Arrays;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTokens("Hello world", "l")));
    }

    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query, delimiter);
        String result[] = new String[st.countTokens()];
        int index = 0;
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            result[index] = token;
            index++;
        }
        return result;
    }
}