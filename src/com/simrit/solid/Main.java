package com.simrit.solid;

import com.simrit.solid.checkout.CheckoutService;
import com.simrit.solid.customer.Customer;
import com.simrit.solid.customer.CustomerTier;
import com.simrit.solid.discount.*;
import com.simrit.solid.order.Order;
import com.simrit.solid.payment.CardPayment;
import com.simrit.solid.payment.PaymentStatus;
import com.simrit.solid.payment.PaymentStrategy;
import com.simrit.solid.product.Product;

public class Main {
    public static void main(String[] args) {
        runOrderAndCheckout();
    }

    private static void runOrderAndCheckout() {
        Product p1 = new Product("L101", "MacBook Air M5", 129000.00);
        Product p2 = new Product("M101", "iPhone 17", 82900.00);
        Product p3 = new Product("MS101", "Mx Master 3s", 6995.00);

        Customer c1 = new Customer("CUST101", "Simrit");
        c1.changeCustomerTier(CustomerTier.PREMIUM);

        Customer c2 = new Customer("CUST102", "John");

        Order order = new Order("O101");
        order.addProduct(p1);
        order.addProduct(p2);
        order.addProduct(p3);
        System.out.println(order);

        DiscountStrategy discount = new ConditionalDiscount(new PremiumCustomerEligibility(), new PercentageDiscount(15));
        PaymentStrategy payment = new CardPayment("5823");

        CheckoutService checkoutService = new CheckoutService(discount, payment);

        var paymentResult = checkoutService.checkout(c1, order);
        if (paymentResult.getStatus() == PaymentStatus.SUCCESS) {
            System.out.println("Payment with Transaction ID: " + paymentResult.getTransactionId() + " was completed successfully");
        }
    }
}
