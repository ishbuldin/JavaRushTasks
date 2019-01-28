package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(br.readLine());
        //FileReader fr = new FileReader("D:/TEST/1.txt");
        BufferedReader reader = new BufferedReader(fr);
        String str;
        ArrayList<String> wordsList = new ArrayList<>();
        while ((str = reader.readLine()) != null) {
            for (String word : str.split("\\s+")) {
                if (!word.isEmpty()) {
                    wordsList.add(word);
                }
            }
        }
        br.close();
        fr.close();
        reader.close();
        ArrayList<String> copyOfWords = new ArrayList<>(wordsList);
        for (int i = 0; i < wordsList.size(); i++) {
            String word = wordsList.get(i);
            String reverseWord = new StringBuilder(word).reverse().toString();
            for (int j = i + 1; j < wordsList.size(); j++) {
                String wordToCompare = wordsList.get(j);
                if (reverseWord.equals(wordToCompare) && !copyOfWords.get(i).equals("added")) {
                    Pair pair = new Pair(word, reverseWord);
                    copyOfWords.set(i, "added");
                    copyOfWords.set(j, "added");
                    result.add(pair);
                }
            }
        }
        //for (Pair pair : result) {
        //    System.out.println(pair.first + " " + pair.second);
        //}

        //System.out.println("---------------------------");
        for (int i = 0; i < result.size(); i++) {
            String first = result.get(i).first;
            for (int j = i + 1; j < result.size(); j++) {
                if (first.equals(result.get(j).first) || first.equals(result.get(j).second)) {
                    result.set(j, new Pair("del", "del"));
                }
            }
        }
        //for (Pair pair : result) {
        //    System.out.println(pair.first + " " + pair.second);
        //}
        for (Pair pair : result) {
            if (pair.first.equals("del")) {
                result.remove(pair);
            }
        }
        for (Pair pair : result) {
            System.out.println(pair.first + " " + pair.second);
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}