package com.example.deliverybooks.domain.shared.validations;

import java.math.BigDecimal;

public final class Checker {
    private Checker() {}

    public static <T> T notNull(T obj, String field) {
        if (obj == null) throw new IllegalArgumentException(field + " cannot be null");
        return obj;
    }

    public static void notNullString(String s) {
        if (s == null) throw new IllegalArgumentException("Null String received");
    }

    public static String notEmptyString(String s) {
        notNullString(s);
        String trimmed = s.trim();
        if (trimmed.isEmpty()) throw new IllegalArgumentException("Empty String received");
        return trimmed;
    }

    public static String minLengthString(String s, int minLength) {
        String trimmed = notEmptyString(s);
        if (trimmed.length() < minLength) throw new IllegalArgumentException("String shorter than " + minLength);
        return trimmed;
    }

    public static String stringBetweenLength(String s, int minLength, int maxLength) {
        String trimmed = minLengthString(s, minLength);
        if (trimmed.length() > maxLength) throw new IllegalArgumentException("String longer than " + maxLength);
        return trimmed;
    }

    public static BigDecimal positive(BigDecimal value, String field) {
        notNull(value, field);
        if (value.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException(field + " must be greater than 0");
        return value;
    }

    public static int nonNegative(int value, String field) {
        if (value < 0) throw new IllegalArgumentException(field + " cannot be negative");
        return value;
    }

    public static int positiveInt(int value, String field) {
        if (value <= 0) throw new IllegalArgumentException(field + " must be greater than 0");
        return value;
    }
}