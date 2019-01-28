package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human grandFa1 = new Human("Василий", true, 60);
        Human grandFa2 = new Human("Валерон", true, 63);
        Human grandMa1 = new Human("Василиса", false, 61);
        Human grandMa2 = new Human("Елена", false, 62);
        Human father = new Human("Владимир" , true, 35, grandFa1, grandMa1);
        Human mother = new Human("Валерия" , false, 34, grandFa2, grandMa2);
        Human anna = new Human("Анна", false, 5, father, mother);
        Human vika = new Human("Вика", false, 7, father, mother);
        Human andrei = new Human("Андрей", true, 10, father, mother);

        System.out.println(grandFa1);
        System.out.println(grandFa2);
        System.out.println(grandMa1);
        System.out.println(grandMa2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(anna);
        System.out.println(vika);
        System.out.println(andrei);

    }

    public static class Human {
        //напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















