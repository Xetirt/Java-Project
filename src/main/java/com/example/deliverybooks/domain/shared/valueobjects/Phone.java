package com.example.deliverybooks.domain.shared.valueobjects;
import java.util.regex.Pattern;

import com.example.deliverybooks.domain.shared.validations.Checker;
public record Phone(String phone) {
    private static final Pattern PHONE_SPAIN_PATTERN = Pattern.compile("^[6789]\\d{8}$");
    public Phone {
        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("Wrong Phone: value cannot be empty or null");
        }
        phone = phone.replaceAll("[\\s\\-]", "");
        if (phone.startsWith("+34")) {
            phone = phone.substring(3);
        } else if (phone.startsWith("0034")) {
            phone = phone.substring(4);
        }
        Checker.stringBetweenLength(phone, 9, 9);
        if (!PHONE_SPAIN_PATTERN.matcher(phone).matches()) {
            throw new IllegalArgumentException("Wrong Phone: must be a valid Spanish phone number starting with 6, 7, 8 or 9 (" + phone + ")");
        }
    }
    @Override
    public String toString() {
        return phone;
    }
}