package com.simrit.patterns.document.job;

public interface JobState {
    void start(DocumentJob job);
    void complete(DocumentJob job);
    void fail(DocumentJob job);
    void retry(DocumentJob job);
}
