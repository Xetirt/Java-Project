package com.example.deliverybooks.domain.shared.valueobjects.mesurament;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.example.deliverybooks.domain.shared.validations.Checker;

public record Distance(BigDecimal value, DistanceUnit unit) {
    public Distance {
        Checker.positive(value, "Distance");
        Checker.notNull(unit, "DistanceUnit");
        value = value.multiply(unit.getMmFactor());
        unit = DistanceUnit.MILIMETER;
    }

    public static Distance of(BigDecimal value, DistanceUnit unit) { return new Distance(value, unit); }

    public BigDecimal getValueIn(DistanceUnit targetUnit) {
        Checker.notNull(targetUnit, "Target unit");
        return value.divide(targetUnit.getMmFactor(), 6, RoundingMode.HALF_UP);
    }
}