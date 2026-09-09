package com.simrit.simpledesign.recipient;

import com.simrit.helpers.IllegalStringArgumentException;
import com.simrit.helpers.ValidationHelper;

public class EmailRecipient implements Recipient {
    private final String email;

    public EmailRecipient(String email) {
        if (ValidationHelper.isNullOrEmpty(email)) throw new IllegalStringArgumentException("Email");
        this.email = email;
    }

    public String getEmail() { return email; }
}
