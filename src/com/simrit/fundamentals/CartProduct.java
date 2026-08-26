package com.simrit.fundamentals;

import java.util.UUID;

public class CartProduct {
    private int id;
    private String name;
    private double price;

    public CartProduct(int id, String name, double price) {
        if (id <= 0) throw new IllegalArgumentException("ID cannot be negative or 0");
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }

        if (price <= 0.0) {
            throw new IllegalArgumentException("Price cannot be negative or 0");
        }

        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public double getPrice() { return this.price; }

    @Override
    public String toString() {
        return "ID #" + this.id + " - " + this.name + " Rs." + this.price;
    }
}
