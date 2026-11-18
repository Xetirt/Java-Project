package com.example.deliverybooks.domain.shared.valueobjects;

import com.example.deliverybooks.domain.shared.validations.Checker;

public record WebSite(String url) {
    public WebSite {
        url = Checker.notEmptyString(url);
        if (!url.matches("^https?://.+\\..+$")) {
            throw new IllegalArgumentException("Invalid WebSite URL: " + url);
        }
    }

    public static WebSite of(String url) { return new WebSite(url); }

    @Override
    public String toString() { return url; }
}