package com.simrit.simpledesign.user;

import com.simrit.helpers.IllegalStringArgumentException;
import com.simrit.helpers.ValidationHelper;
import com.simrit.simpledesign.notification.NotificationPreference;
import com.simrit.simpledesign.notification.NotificationPreferenceType;

import java.util.HashMap;
import java.util.Map;

public class User {
    private final String id;
    private final String name;
    private String email;
    private String phoneNumber;
    private final String deviceToken;
    private final Map<NotificationPreferenceType, NotificationPreference> notificationPreferences;

    public User (String id, String name, String deviceToken) {
        if (ValidationHelper.isNullOrEmpty(id)) throw new IllegalStringArgumentException("Id");
        if (ValidationHelper.isNullOrEmpty(name)) throw new IllegalStringArgumentException("Name");
        if (ValidationHelper.isNullOrEmpty(deviceToken)) throw new IllegalStringArgumentException("Device Token");

        this.id = id;
        this.name = name;
        this.notificationPreferences = new HashMap<>();
        this.email = null;
        this.phoneNumber = null;
        this.deviceToken = deviceToken;
    }

    public String getId() { return id; }

    public String getName() {
        return name;
    }

    public String getEmail() { return this.email; };
    public String getPhoneNumber() { return this.phoneNumber; }
    public String getDeviceToken() { return deviceToken; }

    public void setEmail(String email) {
        if (ValidationHelper.isNullOrEmpty(email)) throw new IllegalStringArgumentException("Email");
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (ValidationHelper.isNullOrEmpty(phoneNumber)) throw new IllegalStringArgumentException("Phone Number");
        this.phoneNumber = phoneNumber;
    }

    public void addNotificationPreference(NotificationPreferenceType type, NotificationPreference notificationPreference) {
        if (type == null) throw new IllegalArgumentException("Notification Type cannot be null");
        if (notificationPreference == null) throw new IllegalArgumentException("Notification Preference cannot be null");

        notificationPreferences.put(type, notificationPreference);
    }

    public NotificationPreference getNotificationPreference(NotificationPreferenceType type) {
        return notificationPreferences.get(type);
    }
}
