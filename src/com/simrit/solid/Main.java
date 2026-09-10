package com.simrit.solid;

import com.simrit.solid.order.Order;
import com.simrit.solid.product.Product;

public class Main {
    public static void main(String[] args) {
        runOrderAndCheckout();
    }

    private static void runOrderAndCheckout() {
        Product p1 = new Product("L101", "MacBook Air M5", 129000.00);
        Product p2 = new Product("M101", "iPhone 17", 82900.00);
        Product p3 = new Product("MS101", "Mx Master 3s", 6995.00);

        Order order = new Order("O101");
        order.addProduct(p1);
        order.addProduct(p2);
        order.addProduct(p3);
        System.out.println(order);
    }
}
