package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private boolean sex = true;
        private String address;
        private String profession;
        private boolean car = false;

        public Human (String name) {
            this.name = name;
        }

        public Human (String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }

        public Human (String name, boolean sex, boolean car) {
            this.name = name;
            this.sex = sex;
            this.car = car;
        }

        public Human (String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human (String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public Human (String name, int age, String address, String profession) {
            this.name = name;
            this.age = age;
            this.address = address;
            this.profession = profession;
        }

        public Human (String name, int age, String address, String profession, boolean car) {
            this.name = name;
            this.age = age;
            this.address = address;
            this.profession = profession;
            this.car = car;
        }

        public Human (String name, int age, String address, String profession, boolean car, boolean sex) {
            this.name = name;
            this.age = age;
            this.address = address;
            this.profession = profession;
            this.car = car;
            this.sex = sex;
        }

        public Human (String name, int age, String profession, boolean car, boolean sex) {
            this.name = name;
            this.age = age;
            this.profession = profession;
            this.car = car;
            this.sex = sex;
        }

        public Human (String name, String profession, boolean car, boolean sex) {
            this.name = name;
            this.profession = profession;
            this.car = car;
            this.sex = sex;
        }

    }
}