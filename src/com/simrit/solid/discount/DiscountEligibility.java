package com.simrit.solid.discount;

public interface DiscountEligibility {
    boolean isEligible(DiscountContext context);
}
