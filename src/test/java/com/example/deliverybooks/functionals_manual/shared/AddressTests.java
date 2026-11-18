package com.example.deliverybooks.functionals_manual.shared;

import com.example.deliverybooks.domain.shared.valueobjects.Addressc;
import com.example.deliverybooks.domain.shared.valueobjects.Addressr;

public final class AddressTests {
    public static void main(String[] args) {
        int passed = 0, failed = 0;

        try {
            Addressc ac = new Addressc("Calle Mayor 12", "Madrid", "28001", "España");
            Addressr ar = new Addressr("Calle Mayor 12", "Madrid", "28001", "España");
            if (!ac.getValue().contains("Madrid") || !"Madrid".equals(ar.city())) throw new IllegalStateException();
            System.out.println("[VERDE] Addressc y Addressr válidos"); passed++;
        } catch (Exception e) { System.out.println("[ROJO] " + e.getMessage()); failed++; }

        try {
            new Addressc("C", "Madrid", "28001", "España");
            System.out.println("[ROJO] Calle corta aceptada"); failed++;
        } catch (IllegalArgumentException e) { System.out.println("[VERDE] Calle corta rechazada"); passed++; }

        try {
            new Addressr("Calle Mayor 12", "Madrid", "12", "España");
            System.out.println("[ROJO] CP inválido aceptado"); failed++;
        } catch (IllegalArgumentException e) { System.out.println("[VERDE] CP inválido rechazado"); passed++; }

        System.out.println("Address: " + passed + " OK, " + failed + " FAIL");
    }
}