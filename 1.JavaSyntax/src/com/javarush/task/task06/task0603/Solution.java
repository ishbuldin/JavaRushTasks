package com.javarush.task.task06.task0603;

/* 
По 50 000 объектов Cat и Dog
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Cat[] arrayCat = new Cat[500000];
        Dog[] arrayDog = new Dog[500000];
        int i = 0;
        while (i < 50000){
            arrayCat[i] = new Cat();
            arrayDog[i] = new Dog();
            arrayCat[i] = null;
            arrayDog[i] = null;
            i++;
        }

    }
}

class Cat {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Cat was destroyed");
    }
}

class Dog {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Dog was destroyed");
    }
}
