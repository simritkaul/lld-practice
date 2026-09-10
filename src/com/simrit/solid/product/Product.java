package com.simrit.solid.product;

import com.simrit.helpers.IllegalStringArgumentException;
import com.simrit.helpers.ValidationHelper;

public class Product {
    private final String id;
    private final String name;
    private double currentPrice;

    public Product(String id, String name, double price) {
        if (ValidationHelper.isNullOrEmpty(id)) throw new IllegalStringArgumentException("ID");
        if (ValidationHelper.isNullOrEmpty(name)) throw new IllegalStringArgumentException("Name");
        if (price <= 0.0) throw new IllegalArgumentException("Price cannot be negative or 0");
        this.id = id;
        this.name = name;
        this.currentPrice = price;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getCurrentPrice() { return currentPrice; }

    public void setCurrentPrice(double price) {
        if (price <= 0.0) throw new IllegalArgumentException("Price cannot be negative or 0");
        this.currentPrice = price;
    }
}
