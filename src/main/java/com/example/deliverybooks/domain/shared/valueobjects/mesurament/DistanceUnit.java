package com.example.deliverybooks.domain.shared.valueobjects.mesurament;

import java.math.BigDecimal;

public enum DistanceUnit {
    MILIMETER(new BigDecimal("1")),
    CENTIMETER(new BigDecimal("10")),
    METER(new BigDecimal("1000")),
    KILOMETER(new BigDecimal("1000000")),
    INCH(new BigDecimal("25.4")),
    FOOT(new BigDecimal("304.8")),
    MILE(new BigDecimal("1609344"));

    private final BigDecimal mmFactor;
    DistanceUnit(BigDecimal mmFactor) { this.mmFactor = mmFactor; }
    public BigDecimal getMmFactor() { return mmFactor; }
}