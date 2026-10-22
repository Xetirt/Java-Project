package com.example.deliverybooks.domain.shared.valueobjects.mesurament;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum WeightUnit {
    GRAMS(new BigDecimal("1")),
    OUNCES(new BigDecimal("28.349523125")),
    POUNDS(new BigDecimal("453.59237")),
    KILOGRAMS(new BigDecimal("1000")),
    TONNES(new BigDecimal("1000000"));

    private final BigDecimal gramsPerUnit;

    WeightUnit(BigDecimal gramsPerUnit) {
        this.gramsPerUnit = gramsPerUnit;
    }

    public BigDecimal toGrams(BigDecimal amount) {
        return amount.multiply(this.gramsPerUnit);
    }

    public BigDecimal fromGrams(BigDecimal grams, int scale, RoundingMode roundingMode) {
        // Evita ArithmeticException al dividir cuando el resultado produce decimales periódicos o infinitos
        return grams.divide(this.gramsPerUnit, scale, roundingMode);
    }
}