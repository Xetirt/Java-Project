package com.example.deliverybooks.domain.shared.valueobjects.mesurament;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
public final class Dimensions{
    private final BigDecimal height;
    private final BigDecimal width;
    private final BigDecimal length;
    private final DistanceUnit unit;

        public Dimensions(BigDecimal height, BigDecimal width, BigDecimal length, DistanceUnit unit){            
            validatePositive(height, "Height");
            validatePositive(width, "Width");
            validatePositive(length, "Length");
            this.unit = Objects.requireNonNull(unit, "Esta unidad no puede ser nula");

            this.height = height;
            this.width = width;
            this.length = length;
        }

        private void validatePositive(BigDecimal value, String fieldName){
            if(value == null || value.compareTo(BigDecimal.ZERO) <= 0){
                throw new IllegalArgumentException(fieldName + "El valor es mayo a 0");
            }
        }

        public BigDecimal getHeight(){
            return height;
        }
        public BigDecimal getWidth(){
            return width;
        }
        public BigDecimal getLength(){
            return length;
        }
        public DistanceUnit getUnit(){
            return unit;
        }

        public BigDecimal getVolume(){
            return height.multiply(width).multiply(length);
        }

        public BigDecimal getVolumeIn(DistanceUnit targetUnit){
            BigDecimal hConvert = convertTo(height, this.unit, targetUnit);
            BigDecimal wConvert = convertTo(width, this.unit, targetUnit);
            BigDecimal lConvert = convertTo(length, this.unit, targetUnit);

            return hConvert.multiply(wConvert).multiply(lConvert);
        }

        private BigDecimal convertTo(BigDecimal value, DistanceUnit from, DistanceUnit to){
            BigDecimal valueInMm = value.multiply(from.getMmFactor());
            return valueInMm.divide(to.getMmFactor(),6, RoundingMode.HALF_UP);
        }
        
        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Dimensions that = (Dimensions) o;

            return toMm(this.height, this.unit).compareTo(toMm(that.height, that.unit)) == 0 &&
                     toMm(this.width, this.unit).compareTo(toMm(that.width, that.unit)) == 0 &&
                     toMm(this.length, this.unit).compareTo(toMm(that.length, that.unit)) == 0;
        }

        private BigDecimal toMm(BigDecimal value, DistanceUnit u){
            return value.multiply(u.getMmFactor());
        }

        @Override
        public int hashCode(){
            return Objects.hash(
                toMm(height, unit),
                toMm(width, unit),
                toMm(length, unit)
            );
        }

        @Override
        public String toString(){
            return String.format("Dimensions{height=%s, width=%s, length=%s, unit=%s}",
                height, width, length, unit
            );
        }
}