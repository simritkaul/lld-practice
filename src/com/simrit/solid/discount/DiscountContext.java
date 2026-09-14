package com.simrit.solid.discount;

import com.simrit.solid.customer.Customer;
import com.simrit.solid.order.Order;

public class DiscountContext {
    private final Customer customer;
    private final Order order;

    public DiscountContext(Customer customer, Order order) {
        if (customer == null) throw new IllegalArgumentException("Customer cannot be null");
        if (order == null) throw new IllegalArgumentException("Order cannot be null");
        this.customer = customer;
        this.order = order;
    }

    public Customer getCustomer() { return customer; }
    public Order getOrder() { return order; }
}
