package com.example.deliverybooks.domain.shared.valueobjects.mesurament;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public record Weight(BigDecimal value, WeightUnit unit) {

    private static final int DEFAULT_SCALE = 6;
    private static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_UP;

    public Weight(BigDecimal value, WeightUnit unit) {
        Objects.requireNonNull(value, "Weight value cannot be null");
        Objects.requireNonNull(unit, "Weight unit cannot be null");

        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }

        // Convierte el valor recibido a gramos y fija GRAMS como la unidad interna
        this.value = unit.toGrams(value);
        this.unit = WeightUnit.GRAMS;
    }

    public BigDecimal getValueIn(WeightUnit targetUnit) {
        return getValueIn(targetUnit, DEFAULT_SCALE, DEFAULT_ROUNDING);
    }

    public BigDecimal getValueIn(WeightUnit targetUnit, int scale, RoundingMode roundingMode) {
        if (targetUnit == WeightUnit.GRAMS) {
            return this.value.setScale(scale, roundingMode);
        }
        return targetUnit.fromGrams(this.value, scale, roundingMode);
    }
}
