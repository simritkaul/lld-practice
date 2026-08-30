package com.simrit.abstractions;

import com.simrit.abstractions.Order;

public class Main {
    public static void main(String[] args) {
        runPayment();
    }

    private static void runPayment() {
        Order order = new Order(101, 1856.50);
        order.pay(new CardPayment());
    }
}
