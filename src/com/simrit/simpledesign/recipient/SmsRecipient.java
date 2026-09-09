package com.simrit.simpledesign.recipient;

import com.simrit.helpers.IllegalStringArgumentException;
import com.simrit.helpers.ValidationHelper;

public class SmsRecipient implements Recipient {
    private final String phoneNumber;

    public SmsRecipient(String phoneNumber) {
        if (ValidationHelper.isNullOrEmpty(phoneNumber)) throw new IllegalStringArgumentException("Phone Number");
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() { return phoneNumber; }
}
