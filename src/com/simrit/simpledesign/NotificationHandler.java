package com.simrit.simpledesign;

import com.simrit.helpers.IllegalStringArgumentException;
import com.simrit.helpers.ValidationHelper;

import java.util.HashSet;
import java.util.Set;

public class NotificationHandler {
    private final Set<NotificationService> notificationServices;

    public NotificationHandler() {
        this.notificationServices = new HashSet<>();
    }

    public void addNotificationService(NotificationService service) {
        if (service == null) throw new IllegalArgumentException("Service cannot be null");
        notificationServices.add(service);
    }

    public void removeNotificationService(NotificationService service) {
        if (service == null) throw new IllegalArgumentException("Service cannot be null");
        notificationServices.remove(service);
    }

    public void notify(User user, NotificationPreferenceType preferenceType, String message) {
        if (user == null) throw new IllegalArgumentException("User cannot be null");
        if (ValidationHelper.isNullOrEmpty(message)) throw new IllegalStringArgumentException("Message");

        for (var service : notificationServices) {
            // Check if transactional notification enabled
            NotificationType type = service.getType();
            if (user.getNotificationPreference(preferenceType).isEnabled(type)) {
                Recipient recipient = RecipientFactory.getRecipient(type, user);
                service.send(recipient, message);
            }
        }
    }
}
