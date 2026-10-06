package com.example.deliverybooks.functionals_manual;
import com.example.deliverybooks.domain.shared.valueobjects.Phone;
public class PhoneTests {
    public static void main(String[] args) {
        
        // Test 1: Móvil válido con prefijo +34
        try {
            Phone p1 = new Phone("+34 612 34 56 78");
            System.out.println("Phone Accepted: " + p1.phone());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        // Test 2: Fijo válido estándar
        try {
            Phone p2 = new Phone("931234567");
            System.out.println("Phone Accepted: " + p2.phone());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        // Test 3: Teléfono no válido (comienza por 5)
        try {
            Phone p3 = new Phone("512345678");
            System.out.println("Phone Accepted: " + p3.phone());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}