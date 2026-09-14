package com.simrit.solid.order;

import com.simrit.helpers.IllegalStringArgumentException;
import com.simrit.helpers.ValidationHelper;
import com.simrit.solid.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private final String id;
    private final Map<String, OrderItem> items;

    public Order (String id) {
        if (ValidationHelper.isNullOrEmpty(id)) throw new IllegalStringArgumentException("ID");
        this.id = id;
        this.items = new HashMap<>();
    }

    public String getId() { return id; }

    public void addProduct(Product product) {
        if (product == null) throw new IllegalArgumentException("Product cannot be null");
        if (items.containsKey(product.getId())) {
            items.get(product.getId()).add();
        } else {
            OrderItem newItem = new OrderItem(product.getId(), product.getName(), product.getCurrentPrice());
            items.put(product.getId(), newItem);
        }
    }

    public void removeProduct(String productId) {
        if (ValidationHelper.isNullOrEmpty(productId)) throw new IllegalStringArgumentException("Product ID");
        if (!items.containsKey(productId)) {
            throw new IllegalStateException("Product with ID " + productId + " does not exist in the order");
        }

        var existingProduct = items.get(productId);
        existingProduct.remove();
        if (existingProduct.getQuantity() == 0) {
            items.remove(productId);
        }
    }

    public double getOrderValue() {
        double value = 0.0;
        for (OrderItem item : items.values()) {
            value += (item.getPriceAtPurchase() * item.getQuantity());
        }
        return value;
    }

    @Override
    public String toString() {
        StringBuilder orderString = new StringBuilder();
        orderString.append("\n----------------------------------------------------------------------");
        for (OrderItem item : items.values()) {
            orderString.append("\n").append(item);
        }
        orderString.append("\n\nTotal Value: ₹").append(getOrderValue());
        orderString.append("\n----------------------------------------------------------------------");
        return orderString.toString();
    }
}
