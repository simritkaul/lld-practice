package com.simrit.patterns.document.job;

public class ProcessingState implements JobState {
    @Override
    public void start(DocumentJob job) {
        throw new IllegalStateException("Processing job cannot be started");
    }

    @Override
    public void complete(DocumentJob job) {
        job.changeState(new CompletedState());
    }

    @Override
    public void fail(DocumentJob job) {
        job.changeState(new FailedState());
    }

    @Override
    public void retry(DocumentJob job) {
        throw new IllegalStateException("Processing job cannot be retried");
    }
}
