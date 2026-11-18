package com.example.deliverybooks.domain.shared.valueobjects.mesurament;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.example.deliverybooks.domain.shared.validations.Check;

public record Distance(BigDecimal value, DistanceUnit unit) {
    public Distance {
        Check.positive(value, "Distance");
        Check.notNull(unit, "DistanceUnit");
        value = value.multiply(unit.getMmFactor());
        unit = DistanceUnit.MILIMETER;
    }

    public static Distance of(BigDecimal value, DistanceUnit unit) {
        return new Distance(value, unit);
    }

    public BigDecimal getValueIn(DistanceUnit targetUnit) {
        Check.notNull(targetUnit, "Target unit");
        return value.divide(targetUnit.getMmFactor(), 6, RoundingMode.HALF_UP);
    }
}