package com.simrit.objectcollaboration;

import java.util.HashSet;
import java.util.Set;

public class NotificationPreferences {
    private Set<NotificationType> enabledNotificationTypes;

    public NotificationPreferences (Set<NotificationType> enabledNotificationTypes) {
        if (enabledNotificationTypes == null) {
            this.enabledNotificationTypes = new HashSet<>();
        } else {
            this.enabledNotificationTypes = new HashSet<>(enabledNotificationTypes);
        }
    }

    public boolean isEnabled(NotificationType notificationType) {
        if (notificationType == null) throw new IllegalArgumentException("Notification Type cannot be null");
        return enabledNotificationTypes.contains(notificationType);
    }
}
