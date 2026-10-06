package com.example.deliverybooks.domain.shared.valueobjects;
import java.util.regex.Pattern;

import com.example.deliverybooks.domain.shared.validations.Checker;
public record Email(String email) {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[a-zA-Z0-9.!#$%&'+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)$"
    );
    public Email {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Wrong Email: value cannot be empty or null");
        }
        email = email.trim();
        Checker.minLengthString(email, 10);
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Wrong Email: no standard format (" + email + ")");
        }
    }
    @Override
    public String toString() {
        return email;
    }
}