package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;
    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<Horse>());
        Horse horse1 = new Horse("horse1", 3, 0);
        Horse horse2 = new Horse("horse2", 3, 0);
        Horse horse3 = new Horse("horse3", 3, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        game.printWinner();
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return this.horses;
    }

    public void move() {
        for (Horse horse : getHorses()) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : getHorses()) {
            horse.print();
        }
        for (int i = 0; i < 10; i++)
            System.out.println();
    }

    public  void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner() {
        Horse result = getHorses().get(0);
        for (Horse horse : getHorses()) {
            if (horse.getDistance() > result.getDistance()) {
                result = horse;
            }
        }
        return result;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

}