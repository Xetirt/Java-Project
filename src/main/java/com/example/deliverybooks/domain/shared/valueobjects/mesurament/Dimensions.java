package com.example.deliverybooks.domain.shared.valueobjects.mesurament;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import com.example.deliverybooks.domain.shared.validations.Check;

public final class Dimensions {
    private final BigDecimal height;
    private final BigDecimal width;
    private final BigDecimal length;
    private final DistanceUnit unit;

    private Dimensions(BigDecimal height, BigDecimal width, BigDecimal length, DistanceUnit unit) {
        this.height = Check.positive(height, "Height");
        this.width = Check.positive(width, "Width");
        this.length = Check.positive(length, "Length");
        this.unit = Check.notNull(unit, "DistanceUnit");
    }

    public static Dimensions of(BigDecimal height, BigDecimal width, BigDecimal length, DistanceUnit unit) {
        return new Dimensions(height, width, length, unit);
    }

    public BigDecimal getHeight() { return height; }
    public BigDecimal getWidth() { return width; }
    public BigDecimal getLength() { return length; }
    public DistanceUnit getUnit() { return unit; }

    public BigDecimal getVolume() {
        return height.multiply(width).multiply(length);
    }

    public BigDecimal getVolumeIn(DistanceUnit targetUnit) {
        Check.notNull(targetUnit, "Target unit");
        BigDecimal hConvert = convertTo(height, this.unit, targetUnit);
        BigDecimal wConvert = convertTo(width, this.unit, targetUnit);
        BigDecimal lConvert = convertTo(length, this.unit, targetUnit);
        return hConvert.multiply(wConvert).multiply(lConvert);
    }

    private BigDecimal convertTo(BigDecimal value, DistanceUnit from, DistanceUnit to) {
        BigDecimal valueInMm = value.multiply(from.getMmFactor());
        return valueInMm.divide(to.getMmFactor(), 6, RoundingMode.HALF_UP);
    }

    private BigDecimal toMm(BigDecimal value, DistanceUnit u) {
        return value.multiply(u.getMmFactor());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dimensions that = (Dimensions) o;
        return toMm(this.height, this.unit).compareTo(toMm(that.height, that.unit)) == 0 &&
               toMm(this.width, this.unit).compareTo(toMm(that.width, that.unit)) == 0 &&
               toMm(this.length, this.unit).compareTo(toMm(that.length, that.unit)) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toMm(height, unit), toMm(width, unit), toMm(length, unit));
    }

    @Override
    public String toString() {
        return String.format("Dimensions{height=%s, width=%s, length=%s, unit=%s}", height, width, length, unit);
    }
}