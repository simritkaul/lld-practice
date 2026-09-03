package com.simrit.helpers;

public class IllegalStringArgumentException extends IllegalArgumentException {
    public IllegalStringArgumentException(String str) {
        super(str + " cannot be null or empty");
    }
}
