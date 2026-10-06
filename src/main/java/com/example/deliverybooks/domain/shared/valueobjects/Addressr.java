package com.example.deliverybooks.domain.shared.valueobjects;
import com.example.deliverybooks.domain.shared.validations.Checker;
public record Addressr(
    String street,
    String city,
    String zipCode,
    String country
){
    public Addressr {
        Checker.minLengthString(street, 5);
        Checker.minLengthString(city, 3);
        Checker.stringBetweenLength(zipCode, 5, 5);
        Checker.minLengthString(country, 5);
    }
    public String getValue() {
        return "[street="+street+
                ",city="+city+
                ",zipCode="+zipCode+
                ",country="+country+"]";
    }
}