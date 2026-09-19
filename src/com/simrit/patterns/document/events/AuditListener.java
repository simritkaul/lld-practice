package com.simrit.patterns.document.events;

public class AuditListener implements Listener<DocumentProcessedEvent> {
    @Override
    public void onEvent(DocumentProcessedEvent event) {
        System.out.println("Processed file: " + event.getFile() + " details added to Audit");
    }
}
