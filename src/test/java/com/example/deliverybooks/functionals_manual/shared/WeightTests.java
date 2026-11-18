package com.example.deliverybooks.functionals_manual.shared;

import java.math.BigDecimal;

import com.example.deliverybooks.domain.shared.valueobjects.mesurament.Weight;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.WeightUnit;

public final class WeightTests {
    public static void main(String[] args) {
        int passed = 0, failed = 0;

        try {
            Weight w = new Weight(new BigDecimal("2"), WeightUnit.KILOGRAMS);
            if (w.value().compareTo(new BigDecimal("2000")) != 0) throw new IllegalStateException();
            System.out.println("[VERDE] Weight válido: " + w.getValueIn(WeightUnit.POUNDS) + " lbs"); passed++;
        } catch (Exception e) { System.out.println("[ROJO] " + e.getMessage()); failed++; }

        try {
            new Weight(new BigDecimal("-5"), WeightUnit.GRAMS);
            System.out.println("[ROJO] Peso negativo aceptado"); failed++;
        } catch (IllegalArgumentException e) { System.out.println("[VERDE] Peso negativo rechazado"); passed++; }

        System.out.println("Weight: " + passed + " OK, " + failed + " FAIL");
    }
}