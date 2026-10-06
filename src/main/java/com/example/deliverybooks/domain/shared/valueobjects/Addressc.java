package com.example.deliverybooks.domain.shared.valueobjects;
import com.example.deliverybooks.domain.shared.validations.Checker;
public final class Addressc {
    private String street;
    private String city;
    private String zipCode;
    private String country;
    public Addressc(String street, String city, String zipCode, String country) {
        setStreet(street);
        setCity(city);
        setZipCode(zipCode);
        setCountry(country);
    }
    public String getStreet() {
        return street;
    }
    public final void setStreet(String street) {
        Checker.minLengthString(street, 5);
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public final void setCity(String city) {
        Checker.minLengthString(city, 3);
        this.city = city;
    }
    public String getZipCode() {
        return zipCode;
    }
    public final void setZipCode(String zipCode) {
        Checker.stringBetweenLength(zipCode, 5, 5);
        this.zipCode = zipCode;
    }
    public String getCountry() {
        return country;
    }
    public final void setCountry(String country) {
        Checker.minLengthString(country, 5);
        this.country = country;
    }
    public String getValue() {
        return street + ", " + zipCode + " " + city + ", " + country;
    }
}