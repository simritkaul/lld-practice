package com.simrit.objectcollaboration;

import java.util.ArrayList;
import java.util.List;

public class NotificationHandler {
    private List<NotificationSender> notificationSenders;

    public NotificationHandler(List<NotificationSender> notificationSenders) {
        if (notificationSenders == null) throw new IllegalArgumentException("Notification Senders cannot be null");
        this.notificationSenders = new ArrayList<>(notificationSenders);
    }

    public void notify(User user, String message) {
        if (user == null) throw new IllegalArgumentException("User cannot be null");
        if (message == null || message.trim().isEmpty()) throw new IllegalArgumentException("Message cannot be null or blank");

        for (NotificationSender notificationSender : notificationSenders) {
            var notificationType = notificationSender.getType();
            if (user.getNotificationPreferences().isEnabled(notificationType)) {
                notificationSender.send(user, message);
            }
        }
    }
}
