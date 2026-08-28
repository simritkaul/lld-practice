package com.simrit.objectcollaboration;

public class SmsSender implements NotificationSender {
    private final NotificationType notificationType;

    public SmsSender() {
        this.notificationType = NotificationType.SMS;
    }

    @Override
    public NotificationType getType() {
        return this.notificationType;
    }

    @Override
    public void send(User user, String message) {
        if (user == null) throw new IllegalArgumentException("User cannot be null");
        if (message == null) throw new IllegalArgumentException("Message cannot be null");

        System.out.println("SMS with message: " + message + " sent to " + user.getPhoneNumber());
    }
}
