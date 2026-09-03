package com.simrit.simpledesign;

public class RecipientFactory {
    public RecipientFactory() {};

    public static Recipient getRecipient(NotificationType type, User user) {
        if (type == null)  throw new IllegalArgumentException("Type cannot be null");
        if (user == null)  throw new IllegalArgumentException("User cannot be null");

        if (type == NotificationType.EMAIL) {
            if (user.getEmail() == null) return null;
            return new EmailRecipient(user.getEmail());
        }

        if (type == NotificationType.SMS) {
            if (user.getPhoneNumber() == null) return null;
            return new SmsRecipient(user.getPhoneNumber());
        }

        if (type == NotificationType.PUSH) {
            return new PushRecipient(user.getDeviceToken());
        }

        return null;
    }
}
