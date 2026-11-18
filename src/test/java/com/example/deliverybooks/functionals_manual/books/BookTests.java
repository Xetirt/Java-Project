package com.example.deliverybooks.functionals_manual.books;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import com.example.deliverybooks.domain.authors.Author;
import com.example.deliverybooks.domain.books.*;
import com.example.deliverybooks.domain.clients.Cif;
import com.example.deliverybooks.domain.publishers.Publisher;
import com.example.deliverybooks.domain.shared.valueobjects.*;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.*;
import com.example.deliverybooks.domain.shared.valueobjects.money.*;

class BookTest {

    @Test
    void shouldCreateValidBook() {
        Author author = Author.of(1L, "Joshua Bloch", LocalDate.of(1961, 8, 28), "", null);
        Publisher publisher = Publisher.of(1L, "Addison-Wesley", Cif.of("B12345678"),
                Addressr.of("Calle Gran Via 10", "Madrid", "28013", "España"),
                Phone.of("911234567"), Email.of("info@addison.com"), null);

        Book book = Book.of(
                1L,
                Isbn.of("978-0-13-468599-1"),
                "Effective Java",
                author,
                LocalDate.of(2018, 1, 6),
                publisher,
                "English",
                0,
                416,
                BindingType.SOFT_COVER,
                Dimensions.of(new BigDecimal("23.5"), new BigDecimal("17.8"), new BigDecimal("2.5"), DistanceUnit.CENTIMETER),
                Weight.of(new BigDecimal("1.5"), WeightUnit.POUNDS),
                null,
                "Java best practices",
                Money.of(new BigDecimal("45.99"), Currency.values()[0])
        );
        book.addGenre(Genre.NON_FICTION);

        assertEquals("Effective Java", book.getTitle());
        assertEquals(1, book.getGenres().size());
    }

    @Test
    void shouldThrowExceptionWhenBookDataIsInvalid() {
        assertThrows(IllegalArgumentException.class, () ->
                Book.of(0L, null, "", null, null, null, "", -1, 0, null, null, null, null, "", null)
        );
    }
}