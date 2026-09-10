package com.simrit.solid.order;

import com.simrit.helpers.ValidationHelper;
import com.simrit.solid.product.Product;

public class OrderItem {
    private final String productId;
    private final String productName;
    private final double priceAtPurchase;
    private int quantity;

    public OrderItem(String productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.priceAtPurchase = price;
        this.quantity = 1;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPriceAtPurchase() { return priceAtPurchase; }
    public int getQuantity() { return quantity; }

    public void add() {
        quantity++;
    }

    public void remove() {
        if (quantity == 0) throw new IllegalStateException("Product quantity is already 0");
        quantity--;
    }

    @Override
    public String toString() {
        return "Name: " + productName + " x " + quantity + " @ ₹" + priceAtPurchase;
    }
}
