package com.example.deliverybooks.functionals_manual;

import com.example.deliverybooks.domain.shared.valueobjects.Addressc;
import com.example.deliverybooks.domain.shared.valueobjects.Addressr;

public final class ValueObjectsTests {
    private ValueObjectsTests() {}
    public static void main(String[] args) {
        int passed = 0, failed = 0;
        try {
            Addressc address = new Addressc("Calle Mayor 12", "Madrid", "28001", "España");
            if (!address.getValue().contains("Madrid")) throw new IllegalStateException("Dirección incompleta");
            Addressr recipient = new Addressr("Calle Mayor 12", "Madrid", "28001", "España");
            if (!"Madrid".equals(recipient.city())) throw new IllegalStateException("Ciudad incorrecta");
            System.out.println("[VERDE] Addressc y Addressr válidos"); passed++;
        } catch (Exception e) { System.out.println("[ROJO] Dirección válida: " + e.getMessage()); failed++; }
        try {
            new Addressc("C", "Madrid", "28001", "España");
            System.out.println("[ROJO] Se aceptó una calle demasiado corta"); failed++;
        } catch (IllegalArgumentException e) { System.out.println("[VERDE] Calle inválida rechazada"); passed++; }
        try {
            new Addressr("Calle Mayor 12", "Madrid", "12", "España");
            System.out.println("[ROJO] Se aceptó un código postal inválido"); failed++;
        } catch (IllegalArgumentException e) { System.out.println("[VERDE] Código postal inválido rechazado"); passed++; }
        System.out.println("Value Objects: " + passed + " correctas, " + failed + " fallidas.");
        if (failed > 0) throw new IllegalStateException("Pruebas Value Objects fallidas");
    }
}
