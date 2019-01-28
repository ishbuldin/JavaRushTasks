package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        //System.out.println("------");
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        return result;
    }

    public static Set<Dog> createDogs() {
        HashSet<Dog> result = new HashSet<Dog>();
        result.add(new Dog());
        result.add(new Dog());
        result.add(new Dog());
        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        //напишите тут ваш код
        HashSet<Object> set = new HashSet<Object>();
        set.addAll(cats);
        set.addAll(dogs);
        return set;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        //напишите тут ваш код
        //pets.removeAll(cats);
        HashSet<Object> copyPets = new HashSet<>(pets);
        Iterator<Object> iteratorPets = copyPets.iterator();
        while (iteratorPets.hasNext()) {
            Iterator<Cat> iteratorCats = cats.iterator();
            Object objectPet = iteratorPets.next();
            while (iteratorCats.hasNext()) {
                Object objectCat = iteratorCats.next();
                if (objectPet.equals(objectCat)) {
                    pets.remove(objectCat);
                }
            }
        }
    }

    public static void printPets(Set<Object> pets) {
        //напишите тут ваш код
        for (Object a : pets) {
            System.out.println(a);
        }
    }

    //напишите тут ваш код
    public static class Cat {}

    public static class Dog {}

}
