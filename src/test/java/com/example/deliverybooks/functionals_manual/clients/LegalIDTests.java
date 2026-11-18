package com.example.deliverybooks.functionals_manual.clients;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.example.deliverybooks.domain.clients.Cif;
import com.example.deliverybooks.domain.clients.Nie;
import com.example.deliverybooks.domain.clients.Nif;

public class LegalIDTests {
    @Test
    void shouldCreateValidLegalIDs() {
        assertEquals("12345678A", Nif.of("12345678a").getLegalID());
        assertEquals("B12345678", Cif.of("b12345678").getLegalID());
        assertEquals("X1234567L", Nie.of("x1234567l").getLegalID());
    }

    @Test
    void shouldThrowExceptionWhenLegalIDsAreInvalid() {
        assertThrows(IllegalArgumentException.class, () -> Nif.of(null));
        assertThrows(IllegalArgumentException.class, () -> Nif.of("123"));
        assertThrows(IllegalArgumentException.class, () -> Cif.of(null));
        assertThrows(IllegalArgumentException.class, () -> Cif.of("12345678A"));
        assertThrows(IllegalArgumentException.class, () -> Nie.of(null));
        assertThrows(IllegalArgumentException.class, () -> Nie.of("A1234567L"));
    }
}