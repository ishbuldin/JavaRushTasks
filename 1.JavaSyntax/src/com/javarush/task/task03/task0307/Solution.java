package com.javarush.task.task03.task0307;

/* 
Привет Starcraft!
*/

import javax.sound.midi.Soundbank;

public class Solution {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            Zerg zerg[] = new Zerg[10];
            zerg[i] = new Zerg();
            zerg[i].name = "zerg" + i;
            System.out.println(zerg[i].name);
        }

        for(int i = 0; i < 5; i++) {
            new Protoss().name = "protos" + i;
        }

        for(int i = 0; i < 12; i++) {
            new Terran().name = "terran" + i;
        }
        //напишите тут ваш код
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
