package com.simrit.inheritance;

public class Warrior extends Character implements Attackable, Movable {
    public Warrior(String name) {
        super(name, 250);
    }

    @Override
    public void move() {
        System.out.println("Warrior " + this.getName() + " is sprinting!");
    }

    @Override
    public void attack() {
        System.out.println(this.getName() + " attacks with a sword!");
    }
}
