package com.simrit.simpledesign.retry;

public class RetryHandler {
    public void execute(Runnable operation, RetryPolicy policy) {
        int attempt = 1;

        while (true) {
            try {
                operation.run();
            } catch (RuntimeException e) {
                if (!policy.shouldRetry(attempt, e)) {
                    throw e;
                }

                attempt++;
            }
        }
    }
}
