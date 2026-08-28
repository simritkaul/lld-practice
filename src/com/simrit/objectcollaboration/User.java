package com.simrit.objectcollaboration;

public class User {
    private String name;
    private String email;
    private String phoneNumber;
    private NotificationPreferences notificationPreferences;

    public User(String name, String email, String phoneNumber, NotificationPreferences notificationPreferences) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        if (email == null || email.trim().isEmpty()) throw new IllegalArgumentException("Email cannot be null or empty");
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) throw new IllegalArgumentException("Phone Number cannot be null or empty");
        if (notificationPreferences == null) throw new IllegalArgumentException("Notification Preferences cannot be null");
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.notificationPreferences = notificationPreferences;
    }

    public String getName() { return this.name; }
    public String getEmail() { return this.email; }
    public String getPhoneNumber() { return this.phoneNumber; }
    public NotificationPreferences getNotificationPreferences() { return this.notificationPreferences; }
}

