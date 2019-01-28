package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(br.readLine());
        //FileReader fr = new FileReader("D:/TEST/2.txt");
        BufferedReader bfr = new BufferedReader(fr);
        String words[] = bfr.readLine().split("\\s+");
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        if (words.length == 0)
            return sb;
        else {
            ArrayList<String> wordsList = new ArrayList<String>(Arrays.asList(words));
            Collections.sort(wordsList);
            ArrayList<String> wordsListCopy = new ArrayList<>(wordsList);
            sb.append(wordsList.get(0));
            wordsListCopy.set(0, "del");
            int index = 1;
            while (index < wordsList.size()) {
                char lastCharAtWord = sb.toString().toLowerCase().charAt(sb.length() - 1);
                char firstCharAtWord = wordsList.get(index).toLowerCase().charAt(0);
                if (lastCharAtWord == firstCharAtWord && !wordsListCopy.get(index).equals("del") && !sb.toString().contains(wordsList.get(index))) {
                    sb.append(" ");
                    sb.append(wordsList.get(index));
                    wordsListCopy.set(index, "del");
                    index = 1;
                }
                else {
                    index++;
                }
            }
            for (String word : wordsListCopy) {
                if (!word.equals("del")) {
                    sb.append(" ");
                    sb.append(word);
                }
            }
            return sb;
        }
    }
}