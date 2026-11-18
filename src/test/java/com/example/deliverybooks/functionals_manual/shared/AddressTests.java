package com.example.deliverybooks.functionals_manual.shared;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.example.deliverybooks.domain.shared.valueobjects.Addressc;
import com.example.deliverybooks.domain.shared.valueobjects.Addressr;

public class AddressTests {
    @Test
    void shouldCreateValidAddresses() {
        Addressc ac = Addressc.of("Calle Mayor 12", "Madrid", "28001", "España");
        Addressr ar = Addressr.of("Calle Mayor 12", "Madrid", "28001", "España");
        assertTrue(ac.getValue().contains("Madrid"));
        assertEquals("Madrid", ar.city());
    }

    @Test
    void shouldThrowExceptionWhenAddressFieldsAreInvalid() {
        assertThrows(IllegalArgumentException.class, () -> Addressc.of("C", "Madrid", "28001", "España"));
        assertThrows(IllegalArgumentException.class, () -> Addressc.of("Calle Mayor 12", "Ma", "28001", "España"));
        assertThrows(IllegalArgumentException.class, () -> Addressr.of("Calle Mayor 12", "Madrid", "12", "España"));
        assertThrows(IllegalArgumentException.class, () -> Addressr.of("Calle Mayor 12", "Madrid", "28001", "ES"));
        assertThrows(IllegalArgumentException.class, () -> Addressr.of(null, "Madrid", "28001", "España"));
    }
}