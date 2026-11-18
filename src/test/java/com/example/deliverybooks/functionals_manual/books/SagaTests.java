package com.example.deliverybooks.functionals_manual.books;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.example.deliverybooks.domain.books.Genre;
import com.example.deliverybooks.domain.books.Saga;

public class SagaTests {
    @Test
    void shouldCreateValidSaga() {
        Saga saga = Saga.of(1L, "Cosmere", "Universo literario");
        saga.addGenre(Genre.FANTASY);
        assertEquals("Cosmere", saga.getName());
        assertEquals(1, saga.getGenres().size());
    }

    @Test
    void shouldThrowExceptionWhenSagaDataIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> Saga.of(0L, "Cosmere", ""));
        assertThrows(IllegalArgumentException.class, () -> Saga.of(1L, "A", ""));
    }
}