package com.example.deliverybooks.functionals_manual;

import com.example.deliverybooks.domain.clients.Cif;

public final class CifTest {
    private CifTest() {}
    public static void main(String[] args) {
        int passed = 0, failed = 0;
        try {
            Cif cif = new Cif("A12345678");
            if (!"A12345678".equals(cif.getLegalID())) throw new IllegalStateException("Valor CIF inesperado");
            System.out.println("[VERDE] CIF instanciado");
            passed++;
        } catch (Exception e) { System.out.println("[ROJO] CIF válido: " + e.getMessage()); failed++; }
        try {
            new Cif(null);
            System.out.println("[ROJO] Se aceptó CIF nulo"); failed++;
        } catch (NullPointerException | IllegalArgumentException e) { System.out.println("[VERDE] CIF nulo rechazado"); passed++; }
        System.out.println("CIF: " + passed + " correctas, " + failed + " fallidas.");
        if (failed > 0) throw new IllegalStateException("Pruebas CIF fallidas");
    }
}
