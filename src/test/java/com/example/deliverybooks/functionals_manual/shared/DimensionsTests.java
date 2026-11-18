package com.example.deliverybooks.functionals_manual.shared;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.Dimensions;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.DistanceUnit;

class DimensionsTest {

    @Test
    void shouldCreateValidDimensionsAndCalculateVolume() {
        Dimensions dim = Dimensions.of(new BigDecimal("20"), new BigDecimal("10"), new BigDecimal("2"), DistanceUnit.CENTIMETER);
        assertEquals(0, dim.getVolume().compareTo(new BigDecimal("400")));
    }

    @Test
    void shouldThrowExceptionWhenDimensionsAreInvalid() {
        assertThrows(IllegalArgumentException.class, () -> Dimensions.of(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.ONE, DistanceUnit.CENTIMETER));
        assertThrows(IllegalArgumentException.class, () -> Dimensions.of(BigDecimal.ONE, new BigDecimal("-1"), BigDecimal.ONE, DistanceUnit.CENTIMETER));
        assertThrows(IllegalArgumentException.class, () -> Dimensions.of(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, null));
    }
}