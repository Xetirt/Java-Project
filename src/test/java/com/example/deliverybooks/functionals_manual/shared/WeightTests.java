package com.example.deliverybooks.functionals_manual.shared;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.Weight;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.WeightUnit;

class WeightTest {

    @Test
    void shouldCreateValidWeightAndConvertUnits() {
        Weight w = Weight.of(new BigDecimal("2"), WeightUnit.KILOGRAMS);
        assertEquals(0, w.value().compareTo(new BigDecimal("2000")));
        assertEquals(WeightUnit.GRAMS, w.unit());
    }

    @Test
    void shouldThrowExceptionWhenWeightIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> Weight.of(BigDecimal.ZERO, WeightUnit.GRAMS));
        assertThrows(IllegalArgumentException.class, () -> Weight.of(new BigDecimal("-5"), WeightUnit.GRAMS));
        assertThrows(IllegalArgumentException.class, () -> Weight.of(null, WeightUnit.GRAMS));
        assertThrows(IllegalArgumentException.class, () -> Weight.of(BigDecimal.ONE, null));
    }
}