package com.simrit.solid.payment;

import com.simrit.helpers.IllegalStringArgumentException;
import com.simrit.helpers.ValidationHelper;

public class CardPayment implements PaymentStrategy {
    private final String cardToken;

    public CardPayment(String cardToken) {
        if (ValidationHelper.isNullOrEmpty(cardToken)) throw new IllegalStringArgumentException("Card Number");
        this.cardToken = cardToken;
    }

    public String getCardToken() { return cardToken; }

    @Override
    public PaymentResult pay(double amount) {
        System.out.println("Processing card payment of ₹" + amount);
        return new PaymentResult(PaymentStatus.SUCCESS, "TXN123");
    }
}
