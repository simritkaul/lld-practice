package com.simrit.simpledesign.recipient;

import com.simrit.helpers.IllegalStringArgumentException;
import com.simrit.helpers.ValidationHelper;

public class PushRecipient implements Recipient {
    private final String deviceToken;

    public PushRecipient(String deviceToken) {
        if (ValidationHelper.isNullOrEmpty(deviceToken)) throw new IllegalStringArgumentException("Device Token");
        this.deviceToken = deviceToken;
    }

    public String getDeviceToken() { return deviceToken; }
}
