package com.simrit.simpledesign;

import com.simrit.simpledesign.notification.*;
import com.simrit.simpledesign.retry.*;
import com.simrit.simpledesign.user.User;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        runNotification();
    }

    private static void runNotification() {
        User firstUser = new User("101", "John", "APPI171001");
        User secondUser = new User("102", "Jen", "SAMSS241002");

        firstUser.setEmail("john@mail.com");
        firstUser.setPhoneNumber("9876676767");

        secondUser.setEmail("jen@mail.com");
        secondUser.setPhoneNumber("9988776655");

        NotificationPreference firstNotificationPreference = new NotificationPreference();
        firstNotificationPreference.addPreference(NotificationType.EMAIL);
        firstNotificationPreference.addPreference(NotificationType.PUSH);
        firstUser.addNotificationPreference(NotificationPreferenceType.TRANSACTIONAL, firstNotificationPreference);

        NotificationPreference secondNotificationPreference = new NotificationPreference();
        secondNotificationPreference.addPreference(NotificationType.EMAIL);
        secondNotificationPreference.addPreference(NotificationType.SMS);
        secondUser.addNotificationPreference(NotificationPreferenceType.TRANSACTIONAL, secondNotificationPreference);

        Map<NotificationType, RetryPolicy> retryPolicies = new HashMap<>();
        retryPolicies.put(NotificationType.EMAIL, new EmailRetryPolicy());
        retryPolicies.put(NotificationType.SMS, new SmsRetryPolicy());
        retryPolicies.put(NotificationType.PUSH, new PushRetryPolicy());

        RetryHandler retryHandler = new RetryHandler();

        NotificationHandler notificationHandler = new NotificationHandler(retryPolicies, retryHandler);
        notificationHandler.addNotificationService(new EmailService());
        notificationHandler.addNotificationService(new SmsService());
        notificationHandler.addNotificationService(new PushService());

        notificationHandler.notify(firstUser, NotificationPreferenceType.TRANSACTIONAL, "Your notification is here!");
        notificationHandler.notify(secondUser, NotificationPreferenceType.TRANSACTIONAL, "Your notification is also here!");
    }
}
