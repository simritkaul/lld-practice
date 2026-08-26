package com.simrit.fundamentals;

public class CartItem {
    private CartProduct product;
    private int count;

    public CartItem(CartProduct product, int count) {
        if (product == null) throw new IllegalArgumentException("Product cannot be null");
        if (count <= 0) throw new IllegalArgumentException("Count cannot be negative or zero");
        this.product = product;
        this.count = count;
    }

    public CartProduct getProduct() { return this.product; }
    public int getCount() { return this.count; }

    public void addQuantity(int quantity) {
        if (quantity <= 0)  throw new IllegalArgumentException("Quantity must be greater than zero.");

        this.count += quantity;
    }

    public void reduceQuantity(int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be greater than zero.");
        if (this.count - quantity >= 0) throw new IllegalStateException("Cannot reduce quantity below zero");
        this.count -= quantity;
    }

    @Override
    public String toString() {
        return this.count  + " count of product: " + this.product.toString();
    }
}
