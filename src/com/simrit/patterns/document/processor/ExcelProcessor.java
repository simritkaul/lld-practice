package com.simrit.patterns.document.processor;

public class ExcelProcessor implements DocumentProcessor {
    @Override
    public String process(String file) {
        System.out.println("PDF Processed: " + file);
        return "Success";
    }
}
