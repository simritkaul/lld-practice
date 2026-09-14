package com.simrit.solid.payment;

import com.simrit.helpers.IllegalStringArgumentException;
import com.simrit.helpers.ValidationHelper;

public class PaymentResult {
    private final PaymentStatus status;
    private final String transactionId;

    public PaymentResult(PaymentStatus status, String transactionId) {
        if (status == null) throw new IllegalArgumentException("Status cannot be null");
        if (ValidationHelper.isNullOrEmpty(transactionId)) throw new IllegalStringArgumentException("Transaction ID");
        this.status = status;
        this.transactionId = transactionId;
    }

    public PaymentStatus getStatus() { return status; }
    public String getTransactionId() { return transactionId; }
}
