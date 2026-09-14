package com.simrit.solid.discount;

public class PercentageDiscount implements DiscountStrategy {
    private final double percentage;

    public PercentageDiscount(double percentage) {
        if (percentage <= 0.0) throw new IllegalArgumentException("Percentage cannot be negative or 0");
        if (percentage > 100.0) throw new IllegalArgumentException("Percentage cannot be greater than 100");

        this.percentage = percentage;
    }

    @Override
    public double calculateDiscount(DiscountContext context) {
        var orderValue = context.getOrder().getOrderValue();
        return (orderValue * percentage) / 100.0;
    }
}
