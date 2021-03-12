package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses;

    public List<Horse> getHorses () {
        return horses;
    }
    public Hippodrome (List list) {
        this.horses = list;
    }

    public void run () throws InterruptedException {
        for (int i = 0; i<100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move () {
        for (Horse horse : horses) {
            horse.move();
        }
    }
    public void print () {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i<10; i++) {
            System.out.println();
        }
    }
    public Horse getWinner() {
            double intDistance = 0;
            int idHorse = 0;
            Horse horseWin = null;
            for (int i = 0; i<horses.size(); i++) {
                if(horses.get(i).getDistance()>intDistance) {
                    intDistance = horses.get(i).getDistance();
                    idHorse = i;
                }
            }
        return horses.get(idHorse);
    }
    public void printWinner() {
        System.out.println("Winner is "+ getWinner().getName() + "!");
    }
    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();

        Horse tanya = new Horse("Tanya", 3, 0);
        Horse vlad = new Horse("Vlad", 3, 0);
        Horse natalya = new Horse("Natalya", 3, 0);

        horses.add(tanya);
        horses.add(vlad);
        horses.add(natalya);

        game = new Hippodrome(horses);

        game.run();
        game.printWinner();
    }
}
