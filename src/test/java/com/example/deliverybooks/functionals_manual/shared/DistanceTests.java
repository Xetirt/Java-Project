package com.example.deliverybooks.functionals_manual.shared;

import java.math.BigDecimal;

import com.example.deliverybooks.domain.shared.valueobjects.mesurament.Distance;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.DistanceUnit;

public final class DistanceTests {
    public static void main(String[] args) {
        int passed = 0, failed = 0;

        try {
            Distance d = Distance.of(new BigDecimal("5"), DistanceUnit.KILOMETER);
            if (d.getValueIn(DistanceUnit.METER).compareTo(new BigDecimal("5000")) != 0) throw new IllegalStateException();
            System.out.println("[VERDE] Distance válido: " + d.getValueIn(DistanceUnit.MILE) + " mi"); passed++;
        } catch (Exception e) { System.out.println("[ROJO] " + e.getMessage()); failed++; }

        try {
            Distance.of(BigDecimal.ZERO, DistanceUnit.METER);
            System.out.println("[ROJO] Distancia 0 aceptada"); failed++;
        } catch (IllegalArgumentException e) { System.out.println("[VERDE] Distancia <= 0 rechazada"); passed++; }

        System.out.println("Distance: " + passed + " OK, " + failed + " FAIL");
    }
}