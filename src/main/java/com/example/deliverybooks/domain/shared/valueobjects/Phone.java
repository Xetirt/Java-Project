package com.example.deliverybooks.domain.shared.valueobjects;

import java.util.regex.Pattern;

import com.example.deliverybooks.domain.shared.validations.Check;

public record Phone(String phone) {
    private static final Pattern PHONE_SPAIN_PATTERN = Pattern.compile("^[6789]\\d{8}$");

    public Phone {
        phone = Check.notEmptyString(phone).replaceAll("[\\s\\-]", "");
        if (phone.startsWith("+34")) {
            phone = phone.substring(3);
        } else if (phone.startsWith("0034")) {
            phone = phone.substring(4);
        }
        Check.stringBetweenLength(phone, 9, 9);
        if (!PHONE_SPAIN_PATTERN.matcher(phone).matches()) {
            throw new IllegalArgumentException("Wrong Phone: invalid Spanish number (" + phone + ")");
        }
    }

    public static Phone of(String phone) {
        return new Phone(phone);
    }

    @Override
    public String toString() {
        return phone;
    }
}