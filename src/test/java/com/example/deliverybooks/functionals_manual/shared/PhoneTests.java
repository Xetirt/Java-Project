package com.example.deliverybooks.functionals_manual.shared;

import com.example.deliverybooks.domain.shared.valueobjects.Phone;

public final class PhoneTests {
    public static void main(String[] args) {
        int passed = 0, failed = 0;

        for (String valid : new String[]{"+34 612 34 56 78", "931234567", "0034-600-123-456"}) {
            try {
                Phone p = new Phone(valid);
                if (p.phone().length() != 9) throw new IllegalStateException();
                System.out.println("[VERDE] Phone válido: " + p.phone()); passed++;
            } catch (Exception e) { System.out.println("[ROJO] " + e.getMessage()); failed++; }
        }

        for (String invalid : new String[]{null, "", "512345678", "123"}) {
            try {
                new Phone(invalid);
                System.out.println("[ROJO] Phone inválido aceptado: " + invalid); failed++;
            } catch (IllegalArgumentException e) { System.out.println("[VERDE] Phone rechazado: " + invalid); passed++; }
        }

        System.out.println("Phone: " + passed + " OK, " + failed + " FAIL");
    }
}