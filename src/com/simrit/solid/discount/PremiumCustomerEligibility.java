package com.simrit.solid.discount;

import com.simrit.solid.customer.CustomerTier;

public class PremiumCustomerEligibility implements DiscountEligibility {
    @Override
    public boolean isEligible(DiscountContext context) {
        return context.getCustomer().getTier() == CustomerTier.PREMIUM;
    }
}
