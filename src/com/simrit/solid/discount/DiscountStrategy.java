package com.simrit.solid.discount;

public interface DiscountStrategy {
    double calculateDiscount(DiscountContext context);
}
