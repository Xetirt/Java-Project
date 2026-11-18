package com.example.deliverybooks.domain.shared.valueobjects.mesurament;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.example.deliverybooks.domain.shared.validations.Check;

public record Weight(BigDecimal value, WeightUnit unit) {
    private static final int DEFAULT_SCALE = 6;
    private static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_UP;

    public Weight {
        Check.positive(value, "Weight");
        Check.notNull(unit, "WeightUnit");
        value = unit.toGrams(value);
        unit = WeightUnit.GRAMS;
    }

    public static Weight of(BigDecimal value, WeightUnit unit) {
        return new Weight(value, unit);
    }

    public BigDecimal getValueIn(WeightUnit targetUnit) {
        return getValueIn(targetUnit, DEFAULT_SCALE, DEFAULT_ROUNDING);
    }

    public BigDecimal getValueIn(WeightUnit targetUnit, int scale, RoundingMode roundingMode) {
        Check.notNull(targetUnit, "Target unit");
        Check.notNull(roundingMode, "RoundingMode");
        if (targetUnit == WeightUnit.GRAMS) {
            return this.value.setScale(scale, roundingMode);
        }
        return targetUnit.fromGrams(this.value, scale, roundingMode);
    }
}