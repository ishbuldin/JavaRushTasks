package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public String name;
    public int age;
    public int weight;
    public int strength;

/*    public Cat(String name, int age, int weight, int strength) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }
*/

    public Cat() {

    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        //return ((anotherCat.weight + anotherCat.strength - anotherCat.age) < (weight + strength - age));
        return (anotherCat.strength < strength);
    }

    public static void main(String[] args) {
        //Cat cat1 = new Cat("Bars",1, 5, 7);
        //Cat cat2 = new Cat("Stepan",1, 5, 5);
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        cat1.strength = 2;
        cat2.strength = 1;
        System.out.println(cat1.fight(cat2));
        System.out.println(cat2.fight(cat1));
    }
}
