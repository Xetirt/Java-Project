package com.example.deliverybooks.functionals_manual.books;

import com.example.deliverybooks.domain.books.Isbn;

public final class IsbnTests {
    public static void main(String[] args) {
        int passed = 0, failed = 0;

        try {
            Isbn isbn13 = Isbn.of("978-0-13-468599-1");
            Isbn isbn10 = Isbn.of("0134685997");
            if (isbn13.value().isEmpty() || isbn10.value().isEmpty()) throw new IllegalStateException();
            System.out.println("[VERDE] ISBN-10 e ISBN-13 válidos"); passed++;
        } catch (Exception e) { System.out.println("[ROJO] " + e.getMessage()); failed++; }

        for (String invalid : new String[]{null, "", "12345", "ABCDEFGHIJ"}) {
            try {
                Isbn.of(invalid);
                System.out.println("[ROJO] ISBN inválido aceptado: " + invalid); failed++;
            } catch (IllegalArgumentException e) { System.out.println("[VERDE] ISBN rechazado: " + invalid); passed++; }
        }

        System.out.println("Isbn: " + passed + " OK, " + failed + " FAIL");
    }
}