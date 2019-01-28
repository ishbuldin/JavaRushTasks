package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Iterator<Cat> iterator = cats.iterator();
        /*
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
            break;
        }
        */
        cats.remove(iterator.next());
        //напишите тут ваш код. step 3 - пункт 3

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        //напишите тут ваш код. step 2 - пункт 2
        HashSet<Cat> set = new HashSet<Cat>();
        set.add(new Cat());
        set.add(new Cat());
        set.add(new Cat());
        return set;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4 - пункт 4
        for (Cat a : cats) {
            System.out.println(a);
        }
    }

    // step 1 - пункт 1
    public static class Cat {
        /*
        private String name;
        public Cat(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return this.name;
        }
        */
    }

}
