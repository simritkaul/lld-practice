package com.simrit.simpledesign;

import com.simrit.helpers.IllegalStringArgumentException;
import com.simrit.helpers.ValidationHelper;

public class EmailService implements NotificationService<EmailRecipient> {
    @Override
    public NotificationType getType() {
        return NotificationType.EMAIL;
    }

    @Override
    public void send(EmailRecipient recipient, String message) {
        if (recipient == null) throw new IllegalArgumentException("Recipient cannot be null");
        if (ValidationHelper.isNullOrEmpty(message)) throw new IllegalStringArgumentException("Message");

        System.out.println("Email has been sent to " + recipient.getEmail() + " : " + message);
    }
}
