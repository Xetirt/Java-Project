package com.example.deliverybooks.domain.shared.valueobjects.mesurament;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public record Distance(BigDecimal value, DistanceUnit unit) {

    private static final int DEFAULT_SCALE = 6;
    private static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_UP;

    public Distance(BigDecimal value, DistanceUnit unit) {
        Objects.requireNonNull(value, "Distance value cannot be null");
        Objects.requireNonNull(unit, "Distance unit cannot be null");

        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Distance cannot be negative");
        }

        // Convierte la distancia recibida a milímetros y fija MILLIMETERS como la unidad interna
        this.value = unit.toMillimeters(value);
        this.unit = DistanceUnit.MILLIMETERS;
    }

    public BigDecimal getValueIn(DistanceUnit targetUnit) {
        return getValueIn(targetUnit, DEFAULT_SCALE, DEFAULT_ROUNDING);
    }

    public BigDecimal getValueIn(DistanceUnit targetUnit, int scale, RoundingMode roundingMode) {
        if (targetUnit == DistanceUnit.MILLIMETERS) {
            return this.value.setScale(scale, roundingMode);
        }
        return targetUnit.fromMillimeters(this.value, scale, roundingMode);
    }
}