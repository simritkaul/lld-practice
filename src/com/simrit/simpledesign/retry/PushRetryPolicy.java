package com.simrit.simpledesign.retry;

public class PushRetryPolicy implements RetryPolicy {
    @Override
    public boolean shouldRetry(int attempt, Exception exception) {
        return attempt < 2;
    }
}
