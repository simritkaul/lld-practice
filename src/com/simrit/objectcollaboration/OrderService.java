package com.simrit.objectcollaboration;

public class OrderService {
    private NotificationHandler notificationHandler;

    public OrderService (NotificationHandler notificationHandler) {
        if (notificationHandler == null) throw new IllegalArgumentException("Notification Handler cannot be null");
        this.notificationHandler = notificationHandler;
    }

    public void placeOrder(User user) {
        if (user == null) throw new IllegalArgumentException("User cannot be null");
        System.out.println("Order Placed!");
        notificationHandler.notify(user, "Your order has been placed!");
    }
}
