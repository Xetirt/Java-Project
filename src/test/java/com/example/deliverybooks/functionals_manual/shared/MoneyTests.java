package com.example.deliverybooks.functionals_manual.shared;

import java.math.BigDecimal;

import com.example.deliverybooks.domain.shared.valueobjects.money.Currency;
import com.example.deliverybooks.domain.shared.valueobjects.money.Money;

public final class MoneyTests {
    public static void main(String[] args) {
        int passed = 0, failed = 0;

        // 1. Creación válida
        try {
            Currency defaultCurrency = Currency.values()[0];
            Money m = Money.of(new BigDecimal("24.99"), defaultCurrency);
            if (m.value().compareTo(new BigDecimal("24.99")) != 0 || m.currency() != defaultCurrency) {
                throw new IllegalStateException("Valor o divisa inesperados");
            }
            System.out.println("[VERDE] Money válido: " + m);
            passed++;
        } catch (Exception e) {
            System.out.println("[ROJO] Money válido: " + e.getMessage());
            failed++;
        }

        // 2. Importe negativo rechazado
        try {
            Money.of(new BigDecimal("-1"), Currency.values()[0]);
            System.out.println("[ROJO] Money negativo aceptado");
            failed++;
        } catch (IllegalArgumentException e) {
            System.out.println("[VERDE] Money negativo rechazado");
            passed++;
        }

        // 3. Importe nulo rechazado
        try {
            Money.of(null, Currency.values()[0]);
            System.out.println("[ROJO] Importe nulo aceptado");
            failed++;
        } catch (IllegalArgumentException e) {
            System.out.println("[VERDE] Importe nulo rechazado");
            passed++;
        }

        // 4. Divisa nula rechazada
        try {
            Money.of(BigDecimal.TEN, null);
            System.out.println("[ROJO] Currency nula aceptada");
            failed++;
        } catch (IllegalArgumentException e) {
            System.out.println("[VERDE] Currency nula rechazada");
            passed++;
        }

        System.out.println("Money: " + passed + " OK, " + failed + " FAIL");
        if (failed > 0) throw new IllegalStateException("Pruebas Money fallidas");
    }
}