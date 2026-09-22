package com.simrit.patterns.document.job;

public class DocumentJob {
    private JobState state;

    public DocumentJob() {
        state = new PendingState();
    }

    public void start() {
        state.start(this);
    }

    public void complete() {
        state.complete(this);
    }

    public void fail() {
        state.fail(this);
    }

    public void retry() {
        state.retry(this);
    }

    void changeState(JobState state) {
        this.state = state;
    }
}
