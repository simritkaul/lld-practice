package com.simrit.simpledesign.retry;

public class SmsRetryPolicy implements RetryPolicy {
    @Override
    public boolean shouldRetry(int attempt, Exception exception) {
        return attempt < 1;
    }
}
