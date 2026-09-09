package com.simrit.simpledesign.retry;

public interface RetryPolicy {
    boolean shouldRetry(int attempt, Exception exception);
}
