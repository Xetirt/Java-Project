package com.example.deliverybooks.functionals_manual.shared;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.example.deliverybooks.domain.shared.valueobjects.Email;

class EmailTest {

    @Test
    void shouldCreateValidEmail() {
        Email email = Email.of("xavier.ramirez@example.com");
        assertEquals("xavier.ramirez@example.com", email.email());
    }

    @Test
    void shouldThrowExceptionWhenEmailIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> Email.of(null));
        assertThrows(IllegalArgumentException.class, () -> Email.of(""));
        assertThrows(IllegalArgumentException.class, () -> Email.of("sin-arroba.com"));
        assertThrows(IllegalArgumentException.class, () -> Email.of("a@b.c"));
    }
}