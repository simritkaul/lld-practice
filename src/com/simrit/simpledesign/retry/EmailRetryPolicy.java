package com.simrit.simpledesign.retry;

public class EmailRetryPolicy implements RetryPolicy {
    @Override
    public boolean shouldRetry(int attempt, Exception exception) {
        return attempt < 3;
    }
}
