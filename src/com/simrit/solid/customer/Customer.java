package com.simrit.solid.customer;

import com.simrit.helpers.IllegalStringArgumentException;
import com.simrit.helpers.ValidationHelper;

public class Customer {
    private final String id;
    private final String name;
    private CustomerTier tier;

    public Customer(String id, String name) {
        if (ValidationHelper.isNullOrEmpty(id)) throw new IllegalStringArgumentException("ID");
        if (ValidationHelper.isNullOrEmpty(name)) throw new IllegalStringArgumentException("Name");
        this.id = id;
        this.name = name;
        this.tier = CustomerTier.REGULAR;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public CustomerTier getTier() { return tier; }

    public void changeCustomerTier(CustomerTier tier) {
        if (tier == null) throw new IllegalArgumentException("Tier cannot be null");
        this.tier = tier;
    }
}
