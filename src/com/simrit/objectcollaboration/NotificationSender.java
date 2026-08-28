package com.simrit.objectcollaboration;

public interface NotificationSender {
    NotificationType getType();
    void send(User user, String message);
}
