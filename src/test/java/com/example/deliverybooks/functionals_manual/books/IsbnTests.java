package com.example.deliverybooks.functionals_manual.books;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.example.deliverybooks.domain.books.Isbn;

class IsbnTest {

    @Test
    void shouldCreateValidIsbn() {
        assertNotNull(Isbn.of("978-0-13-468599-1"));
        assertNotNull(Isbn.of("0134685997"));
    }

    @Test
    void shouldThrowExceptionWhenIsbnIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> Isbn.of(null));
        assertThrows(IllegalArgumentException.class, () -> Isbn.of(""));
        assertThrows(IllegalArgumentException.class, () -> Isbn.of("12345"));
        assertThrows(IllegalArgumentException.class, () -> Isbn.of("ABCDEFGHIJ"));
    }
}