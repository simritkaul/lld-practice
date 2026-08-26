package com.simrit.fundamentals;

import java.util.*;

public class ShoppingCart {
    private Map<Integer, CartItem> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    public void addItem(CartProduct product, int quantity) {
        if (product == null) throw new IllegalArgumentException("Product cannot be null");
        if (quantity <= 0) throw new IllegalArgumentException("Quantity cannot be negative or 0");
        // Match by Product ID
        var existingItem = items.get(product.getId());
        if (existingItem == null) {
            CartItem newCartItem = new CartItem(product, quantity);
            items.put(product.getId(), newCartItem);
        } else {
            existingItem.addQuantity(quantity);
        }
    }

    public List<CartItem> getItems() { return new ArrayList<>(items.values()); }
}
