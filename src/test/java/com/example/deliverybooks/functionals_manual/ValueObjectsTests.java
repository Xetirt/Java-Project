package com.example.deliverybooks.functionals_manual;
import com.example.deliverybooks.domain.shared.valueobjects.Addressc;
import com.example.deliverybooks.domain.shared.valueobjects.Addressr;
public class ValueObjectsTests {
    public static void main(String[] args) {
        System.out.println("FUNCTIONAL MANUAL TESTS");
        Addressr adr = null;
        try {
            adr = new Addressr("ca", "Madrid", "123", "Spain");
            System.out.println(adr.toString());
            System.out.println(adr.city() + ":" + adr.country());
            Addressr adr2 = new Addressr("carrer", "Madrid", "1", "Spain");
            if (adr.equals(adr2)) {
                System.out.println("Same Address");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Addressc adc = new Addressc("carrer major 4", "Madrid", "00869", "Spain");
            System.out.println(adc.getValue());
            if (adr != null) {
                adr = new Addressr(adr.street(), adr.city(), adr.zipCode(), "Portugal");
                System.out.println(adr.toString());
            }
            System.out.println(adc.getCity() + ":" + adc.getCountry());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}