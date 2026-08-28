package com.simrit.objectcollaboration;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        runNotification();
    }

    private static void runNotification() {
        Set<NotificationType> notificationTypes = new HashSet<>();
        notificationTypes.add(NotificationType.EMAIL);
        notificationTypes.add(NotificationType.SMS);

        NotificationPreferences notificationPreferences = new NotificationPreferences(notificationTypes);
        User user = new User("Simrit", "simrit@example.com", "9876554321", notificationPreferences);
        List<NotificationSender> notificationSenders = new ArrayList<>();
        notificationSenders.add(new EmailSender());
        notificationSenders.add(new SmsSender());

        NotificationHandler notificationHandler = new NotificationHandler(notificationSenders);

        OrderService orderService = new OrderService(notificationHandler);
        orderService.placeOrder(user);
    }
}
