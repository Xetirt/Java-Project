package com.example.deliverybooks.functionals_manual.shared;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.example.deliverybooks.domain.shared.valueobjects.Phone;

public class PhoneTests {
    @Test
    void shouldCreateValidPhone() {
        assertEquals("612345678", Phone.of("+34 612 34 56 78").phone());
        assertEquals("931234567", Phone.of("931234567").phone());
        assertEquals("600123456", Phone.of("0034-600-123-456").phone());
    }

    @Test
    void shouldThrowExceptionWhenPhoneIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> Phone.of(null));
        assertThrows(IllegalArgumentException.class, () -> Phone.of(""));
        assertThrows(IllegalArgumentException.class, () -> Phone.of("512345678"));
        assertThrows(IllegalArgumentException.class, () -> Phone.of("123"));
    }
}