package com.simrit.objectcollaboration;

public class EmailSender implements NotificationSender {
    private final NotificationType notificationType;

    public EmailSender() {
        this.notificationType = NotificationType.EMAIL;
    }

    @Override
    public NotificationType getType() {
        return this.notificationType;
    }

    @Override
    public void send(User user, String message) {
        if (user == null) throw new IllegalArgumentException("User cannot be null");
        if (message == null) throw new IllegalArgumentException("Message cannot be null");

        System.out.println("Email with message: " + message + " sent to " + user.getEmail());
    }
}
