package com.simrit.patterns.document.job;

import com.simrit.helpers.IllegalStringArgumentException;
import com.simrit.helpers.ValidationHelper;
import com.simrit.patterns.document.DocumentType;

public class DocumentProcessingJob {
    private final String fileName;
    private final DocumentType documentType;
    private final int priority;
    private final int retryCount;
    private final boolean notificationEnabled;

    private DocumentProcessingJob(Builder builder) {
        this.fileName = builder.fileName;
        this.documentType = builder.documentType;
        this.priority = builder.priority;
        this.retryCount = builder.retryCount;
        this.notificationEnabled = builder.notificationEnabled;
    }

    public static class Builder {
        private final String fileName;
        private final DocumentType documentType;
        private int priority = 0;
        private int retryCount = 0;
        private boolean notificationEnabled = false;

        public Builder(String fileName, DocumentType documentType) {
            if (ValidationHelper.isNullOrEmpty(fileName)) throw new IllegalStringArgumentException("File Name");
            if (documentType == null) throw new IllegalArgumentException("Document Type cannot be null");
            this.fileName = fileName;
            this.documentType = documentType;
        }

        public Builder priority(int priority) {
            if (priority <= 0 || priority > 5) throw new IllegalArgumentException("Priority can only be between 1 and 5");
            this.priority = priority;
            return this;
        }

        public Builder retryCount(int retryCount) {
            if (retryCount < 0 || retryCount > 10) throw new IllegalArgumentException("Retries are allowed only between 0 to 10");
            this.retryCount = retryCount;
            return this;
        }

        public Builder notificationEnabled(boolean notificationEnabled) {
            this.notificationEnabled = notificationEnabled;
            return this;
        }

        public DocumentProcessingJob build() {
            return new DocumentProcessingJob(this);
        }
    }
}
