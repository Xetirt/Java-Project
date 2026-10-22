package com.example.deliverybooks.functionals_manual;

import com.example.deliverybooks.domain.clients.Nie;

public final class NieTests {
    private NieTests() {}
    public static void main(String[] args) {
        int passed = 0, failed = 0;
        try {
            Nie nie = new Nie("X1234567L");
            if (!"X1234567L".equals(nie.getLegalID())) throw new IllegalStateException("Valor NIE inesperado");
            System.out.println("[VERDE] NIE instanciado"); passed++;
        } catch (Exception e) { System.out.println("[ROJO] NIE válido: " + e.getMessage()); failed++; }
        try {
            new Nie(null);
            System.out.println("[ROJO] Se aceptó NIE nulo"); failed++;
        } catch (NullPointerException | IllegalArgumentException e) { System.out.println("[VERDE] NIE nulo rechazado"); passed++; }
        System.out.println("NIE: " + passed + " correctas, " + failed + " fallidas.");
        if (failed > 0) throw new IllegalStateException("Pruebas NIE fallidas");
    }
}
