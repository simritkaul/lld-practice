package com.simrit.patterns;

import com.simrit.patterns.document.events.AuditListener;
import com.simrit.patterns.document.events.DocumentProcessedEvent;
import com.simrit.patterns.document.events.HistoryListener;
import com.simrit.patterns.document.events.Publisher;
import com.simrit.patterns.document.processor.DocumentProcessorFactory;
import com.simrit.patterns.document.DocumentType;

public class Main {
    public static void main(String[] args) {
        runDocProcess();
    }

    private static void runDocProcess() {
        DocumentProcessorFactory factory = new DocumentProcessorFactory();
        var processor = factory.create(DocumentType.PDF);
        processor.process("test2.pdf");

        Publisher<DocumentProcessedEvent> publisher = new Publisher<>();
        publisher.register(new HistoryListener());
        publisher.register(new AuditListener());
        publisher.notify(new DocumentProcessedEvent("test2.pdf"));
    }
}
