package com.simrit.abstractions;

public class CardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount + " received successfully via Card XXXX-XXXX-XXXX.");
    }
}
