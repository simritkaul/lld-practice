package com.simrit.patterns.document.processor;

import com.simrit.patterns.document.DocumentType;

public class DocumentProcessorFactory {
    public DocumentProcessor create(DocumentType type) {
        if (type == null) throw new IllegalArgumentException("Type cannot be null");

        if (type == DocumentType.PDF) return new PdfProcessor();
        if (type == DocumentType.WORD) return new WordProcessor();
        if (type == DocumentType.EXCEL) return new ExcelProcessor();

        throw new IllegalArgumentException("Type doesn't exist");
    }
}
