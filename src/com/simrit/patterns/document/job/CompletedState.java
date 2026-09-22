package com.simrit.patterns.document.job;

public class CompletedState implements JobState {
    @Override
    public void start(DocumentJob job) {
        throw new IllegalStateException("Completed job cannot be started");
    }

    @Override
    public void complete(DocumentJob job) {
        throw new IllegalStateException("Completed job cannot be completed");
    }

    @Override
    public void fail(DocumentJob job) {
        throw new IllegalStateException("Completed job cannot be failed");
    }

    @Override
    public void retry(DocumentJob job) {
        job.changeState(new ProcessingState());
    }
}
