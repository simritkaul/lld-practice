package com.simrit.solid.payment;

public interface PaymentStrategy {
    PaymentResult pay(double amount);
}
