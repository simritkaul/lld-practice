package com.simrit.abstractions;

public class UpiPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount + " received successfully via UPI ID example@ybl.");
    }
}
