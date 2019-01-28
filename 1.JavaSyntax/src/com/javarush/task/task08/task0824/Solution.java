package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human children1 = new Human();
        children1.name = "child1";
        children1.sex = true;
        children1.age = 20;

        Human children2 = new Human();
        children2.name = "child2";
        children2.sex = true;
        children2.age = 18;

        Human children3 = new Human();
        children3.name = "child3";
        children3.sex = false;
        children3.age = 15;

        Human father = new Human();
        father.name = "batyanya";
        father.sex = true;
        father.age = 50;
        father.children.add(children1);
        father.children.add(children2);
        father.children.add(children3);

        Human mother = new Human();
        mother.name = "maman";
        mother.sex = false;
        mother.age = 48;
        mother.children.add(children1);
        mother.children.add(children2);
        mother.children.add(children3);

        Human grandFather1 = new Human();
        grandFather1.name = "ded1";
        grandFather1.sex = true;
        grandFather1.age = 80;
        grandFather1.children.add(father);

        Human grandFather2 = new Human();
        grandFather2.name = "ded2";
        grandFather2.sex = true;
        grandFather2.age = 81;
        grandFather2.children.add(mother);

        Human grandMother1 = new Human();
        grandMother1.name = "babka1";
        grandMother1.sex = false;
        grandMother1.age = 79;
        grandMother1.children.add(father);

        Human grandMother2 = new Human();
        grandMother2.name = "babka2";
        grandMother2.sex = false;
        grandMother2.age = 78;
        grandMother2.children.add(mother);

        System.out.println(grandFather1);
        System.out.println(grandFather2);
        System.out.println(grandMother1);
        System.out.println(grandMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(children1);
        System.out.println(children2);
        System.out.println(children3);
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
