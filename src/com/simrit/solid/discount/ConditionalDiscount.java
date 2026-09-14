package com.simrit.solid.discount;

public class ConditionalDiscount implements DiscountStrategy {
    private final DiscountEligibility eligibility;
    private final DiscountStrategy discount;

    public ConditionalDiscount(DiscountEligibility eligibility, DiscountStrategy discount) {
        if (eligibility == null) throw new IllegalArgumentException("Eligibility cannot be null");
        if (discount == null) throw new IllegalArgumentException("Discount cannot be null");
        this.eligibility = eligibility;
        this.discount = discount;
    }

    @Override
    public double calculateDiscount(DiscountContext context) {
        if (!eligibility.isEligible(context)) return 0;

        return discount.calculateDiscount(context);
    }
}
