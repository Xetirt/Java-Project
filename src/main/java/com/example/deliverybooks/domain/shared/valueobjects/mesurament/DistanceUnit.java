package com.example.deliverybooks.domain.shared.valueobjects.mesurament;
import java.math.BigDecimal;

    public enum DistanceUnit {
        MM(new BigDecimal("1")),
        CM(new BigDecimal("10")),
        M(new BigDecimal("1000")),
        KM(new BigDecimal("1000000")),
        INCH(new BigDecimal("25.4")),
        FEET(new BigDecimal("304.8")),
        MILE(new BigDecimal("1609344"));

        private final BigDecimal mmFactor;

        private DistanceUnit(BigDecimal mmFactor) {
            this.mmFactor = mmFactor;
        }

        public BigDecimal getMmFactor(){
            return mmFactor;
        }
        
}
