package com.example.deliverybooks.functionals_manual;

import com.example.deliverybooks.domain.clients.Nif;

public final class NifTests {
    private NifTests() {}
    public static void main(String[] args) {
        int passed = 0, failed = 0;
        try {
            Nif nif = new Nif("12345678A");
            if (!"12345678A".equals(nif.getLegalID())) throw new IllegalStateException("Valor NIF inesperado");
            System.out.println("[VERDE] NIF instanciado"); passed++;
        } catch (Exception e) { System.out.println("[ROJO] NIF válido: " + e.getMessage()); failed++; }
        try {
            new Nif(null);
            System.out.println("[ROJO] Se aceptó NIF nulo"); failed++;
        } catch (NullPointerException | IllegalArgumentException e) { System.out.println("[VERDE] NIF nulo rechazado"); passed++; }
        System.out.println("NIF: " + passed + " correctas, " + failed + " fallidas.");
        if (failed > 0) throw new IllegalStateException("Pruebas NIF fallidas");
    }
}
