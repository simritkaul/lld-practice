package com.simrit.inheritance;

public class Main {
    public static void main(String[] args) {
        runGame();
    }

    private static void runGame() {
        Warrior warrior = new Warrior("Arjuna");
        Wizard wizard = new Wizard("Merlin");
        TrainingDummy dummy = new TrainingDummy();

        warrior.attack();
        wizard.move();
        warrior.move();
        wizard.attack();
        System.out.println(dummy.getName());
    }
}
