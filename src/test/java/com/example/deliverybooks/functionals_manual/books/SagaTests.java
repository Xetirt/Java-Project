package com.example.deliverybooks.functionals_manual.books;

import com.example.deliverybooks.domain.books.*;

public final class SagaTests {
    public static void main(String[] args) {
        int passed = 0, failed = 0;

        try {
            Saga s = Saga.of(1L, "Cosmere", "Universo literario");
            s.addGenre(Genre.FANTASY);
            if (s.getGenres().size() != 1) throw new IllegalStateException();
            System.out.println("[VERDE] Saga válida: " + s.getName()); passed++;
        } catch (Exception e) { System.out.println("[ROJO] " + e.getMessage()); failed++; }

        try {
            Saga.of(0L, "A", "");
            System.out.println("[ROJO] Saga inválida aceptada"); failed++;
        } catch (IllegalArgumentException e) { System.out.println("[VERDE] Saga inválida rechazado"); passed++; }

        System.out.println("Saga: " + passed + " OK, " + failed + " FAIL");
    }
}