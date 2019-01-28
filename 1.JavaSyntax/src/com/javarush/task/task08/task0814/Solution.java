package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        //напишите тут ваш код
        HashSet<Integer> set = new HashSet<>();
        Random random = new Random();
        while (set.size() < 20) {
            set.add(random.nextInt(30));
        }
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        //напишите тут ваш код
        HashSet<Integer> result = (HashSet<Integer>) set.clone();
        for (Integer a : set) {
            if (a > 10) {
                result.remove(a);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        //HashSet<Integer> set = createSet();
        //set = removeAllNumbersMoreThan10(set);
        //for (Integer a : set) {
        //    System.out.println(a);
        //}
    }
}
