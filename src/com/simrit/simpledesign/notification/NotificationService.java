package com.simrit.simpledesign.notification;

import com.simrit.simpledesign.recipient.Recipient;

public interface NotificationService<T extends Recipient> {
    NotificationType getType();
    void send(T recipient, String message);
}
