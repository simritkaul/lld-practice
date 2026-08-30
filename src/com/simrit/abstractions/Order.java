package com.simrit.abstractions;

public class Order {
    private final int id;
    private double totalAmount;

    public Order (int id, double totalAmount) {
        if (id <= 0) throw new IllegalArgumentException("ID cannot be null or 0");
        if (totalAmount <= 0.0) throw new IllegalArgumentException("Total Amount cannot be null or 0");
        this.id = id;
        this.totalAmount = totalAmount;
    }

    public int getId() { return this.id; }
    public double getTotalAmount() { return this.totalAmount; }

    public void pay(PaymentMethod paymentMethod) {
        if (paymentMethod == null) throw new IllegalArgumentException("Payment Method cannot be null");
        paymentMethod.pay(this.totalAmount);
        System.out.println("Order payment processed successfully");
    }
}
