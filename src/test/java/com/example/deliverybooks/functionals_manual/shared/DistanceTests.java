package com.example.deliverybooks.functionals_manual.shared;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.example.deliverybooks.domain.shared.valueobjects.mesurament.Distance;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.DistanceUnit;

public class DistanceTests {
    @Test
    void shouldCreateValidDistanceAndConvertUnits() {
        Distance d = Distance.of(new BigDecimal("5"), DistanceUnit.KILOMETER);
        assertEquals(0, d.getValueIn(DistanceUnit.METER).compareTo(new BigDecimal("5000")));
    }

    @Test
    void shouldThrowExceptionWhenDistanceIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> Distance.of(BigDecimal.ZERO, DistanceUnit.METER));
        assertThrows(IllegalArgumentException.class, () -> Distance.of(new BigDecimal("-2"), DistanceUnit.METER));
        assertThrows(IllegalArgumentException.class, () -> Distance.of(null, DistanceUnit.METER));
        assertThrows(IllegalArgumentException.class, () -> Distance.of(BigDecimal.ONE, null));
    }
}