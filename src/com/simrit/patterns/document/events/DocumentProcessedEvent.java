package com.simrit.patterns.document.events;

import com.simrit.helpers.IllegalStringArgumentException;
import com.simrit.helpers.ValidationHelper;

public class DocumentProcessedEvent implements Event {
    private final String file;

    public DocumentProcessedEvent(String file) {
        if (ValidationHelper.isNullOrEmpty(file)) throw new IllegalStringArgumentException("File");
        this.file = file;
    }

    public String getFile() { return file; }
}
