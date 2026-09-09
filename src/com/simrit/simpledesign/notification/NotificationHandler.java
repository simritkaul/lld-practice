package com.simrit.simpledesign.notification;

import com.simrit.helpers.IllegalStringArgumentException;
import com.simrit.helpers.ValidationHelper;
import com.simrit.simpledesign.recipient.Recipient;
import com.simrit.simpledesign.recipient.RecipientFactory;
import com.simrit.simpledesign.retry.RetryHandler;
import com.simrit.simpledesign.retry.RetryPolicy;
import com.simrit.simpledesign.user.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NotificationHandler {
    private final Set<NotificationService> notificationServices;
    private final Map<NotificationType, RetryPolicy> retryPolicies;
    private final RetryHandler retryHandler;

    public NotificationHandler(Map<NotificationType, RetryPolicy> typeRetryPolicy, RetryHandler retryHandler) {
        if (typeRetryPolicy == null) throw new IllegalArgumentException("Type Retry Policy cannot be null");
        if (retryHandler == null) throw new IllegalArgumentException("Retry handler cannot be null");
        this.notificationServices = new HashSet<>();
        this.retryPolicies = new HashMap<>(typeRetryPolicy);
        this.retryHandler = retryHandler;
    }

    public void addNotificationService(NotificationService service) {
        if (service == null) throw new IllegalArgumentException("Service cannot be null");
        if (!retryPolicies.containsKey(service.getType())) throw new IllegalStateException("This service cannot be registered as a retry policy for this type doesn't exist");
        notificationServices.add(service);
    }

    public void removeNotificationService(NotificationService service) {
        if (service == null) throw new IllegalArgumentException("Service cannot be null");
        notificationServices.remove(service);
    }

    public void notify(User user, NotificationPreferenceType preferenceType, String message) {
        if (user == null) throw new IllegalArgumentException("User cannot be null");
        if (preferenceType == null) throw new IllegalArgumentException("Preference type cannot be null");
        if (ValidationHelper.isNullOrEmpty(message)) throw new IllegalStringArgumentException("Message");

        for (var service : notificationServices) {
            // Check if transactional notification enabled
            NotificationType type = service.getType();
            var notificationPreference = user.getNotificationPreference(preferenceType);
            if (notificationPreference == null) continue;

            if (notificationPreference.isEnabled(type)) {
                Recipient recipient = RecipientFactory.getRecipient(type, user);

                RetryPolicy retryPolicy = retryPolicies.get(type);
                retryHandler.execute(() -> service.send(recipient, message), retryPolicy);
            }
        }
    }
}
