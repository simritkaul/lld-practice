package com.simrit.patterns.document.processor;

public class WordProcessor implements DocumentProcessor {
    @Override
    public String process(String file) {
        System.out.println("Word Processed: " + file);
        return "Success";
    }
}
