package com.simrit.solid.checkout;

import com.simrit.solid.customer.Customer;
import com.simrit.solid.discount.DiscountContext;
import com.simrit.solid.discount.DiscountStrategy;
import com.simrit.solid.order.Order;
import com.simrit.solid.payment.PaymentResult;
import com.simrit.solid.payment.PaymentStrategy;

public class CheckoutService {
    private final DiscountStrategy discount;
    private final PaymentStrategy payment;

    public CheckoutService(DiscountStrategy discount, PaymentStrategy payment) {
        if (discount == null) throw new IllegalArgumentException("Discount cannot be null");
        if (payment == null) throw new IllegalArgumentException("Payment cannot be null");
        this.discount = discount;
        this.payment = payment;
    }

    public PaymentResult checkout(Customer customer, Order order) {
        if (customer == null) throw new IllegalArgumentException("Customer cannot be null");
        if (order == null) throw new IllegalArgumentException("Order cannot be null");

        DiscountContext context = new DiscountContext(customer, order);

        double orderValue = order.getOrderValue();
        double discountedOrderValue = orderValue - discount.calculateDiscount(context);
        System.out.println("Order Value of ₹" + orderValue + " after discount is ₹" + discountedOrderValue);

        return payment.pay(discountedOrderValue);
    }
}
