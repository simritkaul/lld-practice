package com.simrit.inheritance;

public class Wizard extends Character implements Attackable, Movable {
    public Wizard(String name) {
        super(name, 150);
    }

    @Override
    public void move() {
        System.out.println("Wizard " + this.getName() + " is flying!");
    }

    @Override
    public void attack() {
        System.out.println(this.getName() + " attacks with a spell!");
    }
}
