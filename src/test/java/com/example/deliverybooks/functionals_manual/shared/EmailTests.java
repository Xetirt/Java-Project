package com.example.deliverybooks.functionals_manual.shared;

import com.example.deliverybooks.domain.shared.valueobjects.Email;

public final class EmailTests {
    public static void main(String[] args) {
        int passed = 0, failed = 0;

        try {
            Email email = new Email("xavier.ramirez@example.com");
            if (!"xavier.ramirez@example.com".equals(email.email())) throw new IllegalStateException();
            System.out.println("[VERDE] Email válido"); passed++;
        } catch (Exception e) { System.out.println("[ROJO] " + e.getMessage()); failed++; }

        for (String invalid : new String[]{null, "", "sin-arroba", "a@b.c"}) {
            try {
                new Email(invalid);
                System.out.println("[ROJO] Email inválido aceptado: " + invalid); failed++;
            } catch (IllegalArgumentException e) { System.out.println("[VERDE] Email rechazado: " + invalid); passed++; }
        }

        System.out.println("Email: " + passed + " OK, " + failed + " FAIL");
    }
}