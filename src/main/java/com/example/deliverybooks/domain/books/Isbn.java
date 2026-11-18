package com.example.deliverybooks.domain.books;

import com.example.deliverybooks.domain.shared.validations.Checker;

public record Isbn(String value) {
    public Isbn {
        value = Checker.notEmptyString(value);
        String digits = value.replace("-", "");
        if (!digits.matches("^(\\d{10}|\\d{13})$")) {
            throw new IllegalArgumentException("Invalid ISBN (must have 10 or 13 digits): " + value);
        }
    }

    public static Isbn of(String value) { return new Isbn(value); }

    @Override
    public String toString() { return value; }
}