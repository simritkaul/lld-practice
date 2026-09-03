package com.simrit.simpledesign;

import com.simrit.helpers.IllegalStringArgumentException;
import com.simrit.helpers.ValidationHelper;

public class PushService implements NotificationService<PushRecipient> {
    @Override
    public NotificationType getType() {
        return NotificationType.PUSH;
    }

    @Override
    public void send(PushRecipient recipient, String message) {
        if (recipient == null) throw new IllegalArgumentException("Recipient cannot be null");
        if (ValidationHelper.isNullOrEmpty(message)) throw new IllegalStringArgumentException("Message");

        System.out.println("Push notification has been sent to " + recipient.getDeviceToken() + " : " + message);
    }
}
