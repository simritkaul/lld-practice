package com.simrit.patterns.document.job;

public class PendingState implements JobState {
    @Override
    public void start(DocumentJob job) {
        job.changeState(new ProcessingState());
    }

    @Override
    public void complete(DocumentJob job) {
        throw new IllegalStateException("Pending job cannot be completed");
    }

    @Override
    public void fail(DocumentJob job) {
        throw new IllegalStateException("Pending job cannot be failed");
    }

    @Override
    public void retry(DocumentJob job) {
        throw new IllegalStateException("Pending job cannot be retried");
    }
}
