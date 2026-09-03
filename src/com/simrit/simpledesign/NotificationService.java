package com.simrit.simpledesign;

public interface NotificationService<T extends Recipient> {
    NotificationType getType();
    void send(T recipient, String message);
}
