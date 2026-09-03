package com.simrit.simpledesign;

import com.simrit.helpers.IllegalStringArgumentException;
import com.simrit.helpers.ValidationHelper;

public class SmsService implements NotificationService<SmsRecipient> {
    @Override
    public NotificationType getType() {
        return NotificationType.SMS;
    }

    @Override
    public void send(SmsRecipient recipient, String message) {
        if (recipient == null) throw new IllegalArgumentException("Recipient cannot be null");
        if (ValidationHelper.isNullOrEmpty(message)) throw new IllegalStringArgumentException("Message");

        System.out.println("SMS has been sent to " + recipient.getPhoneNumber() + " : " + message);
    }
}
