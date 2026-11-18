package com.example.deliverybooks.domain.shared.valueobjects;

import com.example.deliverybooks.domain.shared.validations.Check;

public record Addressr(String street, String city, String zipCode, String country) {
    public Addressr {
        street = Check.minLengthString(street, 5);
        city = Check.minLengthString(city, 3);
        zipCode = Check.stringBetweenLength(zipCode, 5, 5);
        country = Check.minLengthString(country, 5);
    }

    public static Addressr of(String street, String city, String zipCode, String country) {
        return new Addressr(street, city, zipCode, country);
    }

    public String getValue() {
        return "[street=" + street + ",city=" + city + ",zipCode=" + zipCode + ",country=" + country + "]";
    }
}