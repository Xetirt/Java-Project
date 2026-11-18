package com.example.deliverybooks.domain.shared.valueobjects;

import java.util.regex.Pattern;

import com.example.deliverybooks.domain.shared.validations.Check;

public record Email(String email) {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[a-zA-Z0-9.!#$%&'+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)$"
    );

    public Email {
        email = Check.minLengthString(email, 10);
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Wrong Email: no standard format (" + email + ")");
        }
    }

    public static Email of(String email) {
        return new Email(email);
    }

    @Override
    public String toString() {
        return email;
    }
}