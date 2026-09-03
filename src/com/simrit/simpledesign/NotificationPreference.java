package com.simrit.simpledesign;

import java.util.HashSet;
import java.util.Set;

public class NotificationPreference {
    private final Set<NotificationType> enabledTypes;

    public NotificationPreference() {
        enabledTypes = new HashSet<>();
    }

    public void addPreference(NotificationType notificationType) {
        if (notificationType == null) throw new IllegalArgumentException("Notification Type cannot be null");
        enabledTypes.add(notificationType);
    }

    public void removePreference(NotificationType notificationType) {
        if (notificationType == null) throw new IllegalArgumentException("Notification Type cannot be null");
        enabledTypes.remove(notificationType);
    }

    public boolean isEnabled(NotificationType notificationType) {
        if (notificationType == null) throw new IllegalArgumentException("Notification Type cannot be null");
        return enabledTypes.contains(notificationType);
    }
}
