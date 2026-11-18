package com.example.deliverybooks.domain.shared.valueobjects;

import com.example.deliverybooks.domain.shared.validations.Check;

public final class Addressc {
    private String street;
    private String city;
    private String zipCode;
    private String country;

    private Addressc(String street, String city, String zipCode, String country) {
        setStreet(street);
        setCity(city);
        setZipCode(zipCode);
        setCountry(country);
    }

    public static Addressc of(String street, String city, String zipCode, String country) {
        return new Addressc(street, city, zipCode, country);
    }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = Check.minLengthString(street, 5); }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = Check.minLengthString(city, 3); }

    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = Check.stringBetweenLength(zipCode, 5, 5); }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = Check.minLengthString(country, 5); }

    public String getValue() {
        return street + ", " + zipCode + " " + city + ", " + country;
    }
}