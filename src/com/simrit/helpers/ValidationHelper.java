package com.simrit.helpers;

public class ValidationHelper {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
