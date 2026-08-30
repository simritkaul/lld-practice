package com.simrit.inheritance;

public abstract class Character {
    private String name;
    private int health;

    public Character(String name, int health) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        if (health <= 0) throw new IllegalArgumentException("Health cannot be negative or 0");
        this.name = name;
        this.health = health;
    }

    public String getName() { return this.name; }
    public int getHealth() { return this.health; }

    public void takeDamage(int healthPoints) {
        if (healthPoints <= 0) throw new IllegalArgumentException("Health cannot be negative or 0");
        health = Math.max(0, this.health - healthPoints);
    }

    public void gainHealth(int healthPoints) {
        if (healthPoints <= 0) throw new IllegalArgumentException("Health cannot be negative or 0");
        health += healthPoints;
    }
}
