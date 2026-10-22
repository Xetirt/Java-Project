package com.example.deliverybooks.domain.shared.valueobjects.mesurament;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum DistanceUnit {
    MILLIMETERS(new BigDecimal("1")),
    CENTIMETERS(new BigDecimal("10")),
    METERS(new BigDecimal("1000")),
    KILOMETERS(new BigDecimal("1000000")),
    INCHES(new BigDecimal("25.4")),
    FEET(new BigDecimal("304.8")),
    YARDS(new BigDecimal("914.4")),
    MILES(new BigDecimal("1609344"));

    private final BigDecimal millimetersPerUnit;

    DistanceUnit(BigDecimal millimetersPerUnit) {
        this.millimetersPerUnit = millimetersPerUnit;
    }

    public BigDecimal toMillimeters(BigDecimal amount) {
        return amount.multiply(this.millimetersPerUnit);
    }

    public BigDecimal fromMillimeters(BigDecimal millimeters, int scale, RoundingMode roundingMode) {
        // Previene ArithmeticException en divisiones con decimales infinitos/periódicos (ej. conversiones de millas o yardas)
        return millimeters.divide(this.millimetersPerUnit, scale, roundingMode);
    }
}