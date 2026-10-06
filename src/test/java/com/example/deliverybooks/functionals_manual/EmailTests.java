package com.example.deliverybooks.functionals_manual;
import com.example.deliverybooks.domain.shared.valueobjects.Email;
public class EmailTests {
public static void main(String[] args) {
    try {
    Email e = new Email("g1xaviert@gmail.com");
    System.out.println("Email Accepted " + e.email());
} catch (IllegalArgumentException ex) {
    System.out.println(ex.getMessage());
}
    try {
        Email e = new Email ("_x@rm.com");
        System.out.println("Email Accepted " + e.email());
    }catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
}