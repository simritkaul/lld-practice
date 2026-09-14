package com.simrit.solid.discount;

public class FixedDiscount implements DiscountStrategy {
    private final double amount;

    public FixedDiscount(double amount) {
        if (amount <= 0.0) throw new IllegalArgumentException("Amount cannot be negative or 0");
        this.amount = amount;
    }

    @Override
    public double calculateDiscount(DiscountContext context) {
        var orderValue = context.getOrder().getOrderValue();
        return Math.min(orderValue, amount);
    }
}
