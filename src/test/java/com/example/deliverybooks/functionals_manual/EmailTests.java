package com.example.deliverybooks.functionals_manual;

import com.example.deliverybooks.domain.shared.valueobjects.Email;

public final class EmailTests {
    private EmailTests() {}
    public static void main(String[] args) {
        int passed = 0, failed = 0;
        try {
            Email email = new Email("xavier.ramirez@example.com");
            if (!"xavier.ramirez@example.com".equals(email.email())) throw new IllegalStateException("Email inesperado");
            System.out.println("[VERDE] Email válido"); passed++;
        } catch (Exception e) { System.out.println("[ROJO] Email válido: " + e.getMessage()); failed++; }
        String[] invalid = {null, "", "   ", "correo-sin-formato", "_x@rm.com"};
        for (String value : invalid) {
            try {
                new Email(value);
                System.out.println("[ROJO] Email inválido aceptado: " + value); failed++;
            } catch (IllegalArgumentException e) { System.out.println("[VERDE] Email inválido rechazado: " + value); passed++; }
        }
        System.out.println("Email: " + passed + " correctas, " + failed + " fallidas.");
        if (failed > 0) throw new IllegalStateException("Pruebas Email fallidas");
    }
}
