package com.example.deliverybooks.functionals_manual.shared;

import java.math.BigDecimal;

import com.example.deliverybooks.domain.shared.valueobjects.mesurament.Dimensions;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.DistanceUnit;

public final class DimensionsTests {
    public static void main(String[] args) {
        int passed = 0, failed = 0;

        try {
            Dimensions dim = new Dimensions(new BigDecimal("20"), new BigDecimal("10"), new BigDecimal("2"), DistanceUnit.CENTIMETER);
            if (dim.getVolume().compareTo(new BigDecimal("400")) != 0) throw new IllegalStateException();
            System.out.println("[VERDE] Dimensions válido, volumen: " + dim.getVolume()); passed++;
        } catch (Exception e) { System.out.println("[ROJO] " + e.getMessage()); failed++; }

        try {
            new Dimensions(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.ONE, DistanceUnit.CENTIMETER);
            System.out.println("[ROJO] Dimensión 0 aceptada"); failed++;
        } catch (IllegalArgumentException e) { System.out.println("[VERDE] Dimensión <= 0 rechazada"); passed++; }

        System.out.println("Dimensions: " + passed + " OK, " + failed + " FAIL");
    }
}