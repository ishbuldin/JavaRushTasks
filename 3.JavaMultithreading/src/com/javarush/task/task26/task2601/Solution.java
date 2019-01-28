package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] myarr = {13, 11, 15, 5, 17, 14};
        System.out.println(Arrays.toString(sort(myarr)));
        System.out.println(Arrays.toString(sort2(myarr)));

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        int mediana;
        if (array.length % 2 != 0) {
            mediana = array[Math.floorDiv(array.length, 2)];
        }
        else {
            mediana = (array[array.length / 2] + array[(array.length / 2) - 1]) / 2;
        }
        //System.out.println("mediana - " + mediana);
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(array[j] - mediana) > Math.abs(array[j+1] - mediana)) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
                else if (Math.abs(array[j] - mediana) == Math.abs(array[j+1] - mediana)) {
                    if (array[j] > array[j+1]) {
                        int tmp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = tmp;
                    }
                }
            }
        }
        return array;
    }

    public static Integer[] sort2(Integer[] array) {
        Arrays.sort(array);
        int mediana;
        if (array.length % 2 != 0) {
            mediana = array[Math.floorDiv(array.length, 2)];
        }
        else {
            mediana = (array[array.length / 2] + array[(array.length / 2) - 1]) / 2;
        }
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = Math.abs(o1 - mediana);
                int b = Math.abs(o2 - mediana);
                return a - b;
            }
        };
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, array);
        arrayList.sort(comparator);
        return arrayList.toArray(array);
    }
}