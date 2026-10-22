package com.example.deliverybooks.functionals_manual;

import com.example.deliverybooks.domain.shared.valueobjects.Phone;

public final class PhoneTests {
    private PhoneTests() {}
    public static void main(String[] args) {
        int passed = 0, failed = 0;
        String[] valid = {"+34 612 34 56 78", "931234567", "0034-600-123-456"};
        for (String value : valid) {
            try {
                Phone phone = new Phone(value);
                if (phone.phone() == null || phone.phone().length() != 9) throw new IllegalStateException("Normalización incorrecta");
                System.out.println("[VERDE] Teléfono válido: " + phone.phone()); passed++;
            } catch (Exception e) { System.out.println("[ROJO] Teléfono válido: " + e.getMessage()); failed++; }
        }
        String[] invalid = {null, "", "512345678", "123", "abcdefghij"};
        for (String value : invalid) {
            try { new Phone(value); System.out.println("[ROJO] Teléfono inválido aceptado: " + value); failed++; }
            catch (IllegalArgumentException e) { System.out.println("[VERDE] Teléfono inválido rechazado: " + value); passed++; }
        }
        System.out.println("Teléfono: " + passed + " correctas, " + failed + " fallidas.");
        if (failed > 0) throw new IllegalStateException("Pruebas Phone fallidas");
    }
}
