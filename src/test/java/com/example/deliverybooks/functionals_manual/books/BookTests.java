package com.example.deliverybooks.functionals_manual.books;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.deliverybooks.domain.authors.Author;
import com.example.deliverybooks.domain.books.BindingType;
import com.example.deliverybooks.domain.books.Book;
import com.example.deliverybooks.domain.books.Genre;
import com.example.deliverybooks.domain.books.Isbn;
import com.example.deliverybooks.domain.clients.Cif;
import com.example.deliverybooks.domain.publishers.Publisher;
import com.example.deliverybooks.domain.shared.valueobjects.Addressr;
import com.example.deliverybooks.domain.shared.valueobjects.Email;
import com.example.deliverybooks.domain.shared.valueobjects.Phone;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.Dimensions;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.DistanceUnit;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.Weight;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.WeightUnit;
import com.example.deliverybooks.domain.shared.valueobjects.money.Currency;
import com.example.deliverybooks.domain.shared.valueobjects.money.Money;

public final class BookTests {
    public static void main(String[] args) {
        int passed = 0, failed = 0;

        try {
            Author author = Author.of(1L, "Joshua Bloch", LocalDate.of(1961, 8, 28), "", null);
            Publisher publisher = Publisher.of(1L, "Addison-Wesley", new Cif("B12345678"),
                    new Addressr("Calle Gran Via 10", "Madrid", "28013", "España"),
                    new Phone("911234567"), new Email("info@addison.com"), null);
            Dimensions dim = new Dimensions(new BigDecimal("23.5"), new BigDecimal("17.8"), new BigDecimal("2.5"), DistanceUnit.CENTIMETER);
            Weight weight = new Weight(new BigDecimal("1.5"), WeightUnit.POUNDS);

            Book book = Book.of(1L, Isbn.of("978-0-13-468599-1"), "Effective Java", author,
                    LocalDate.of(2018, 1, 6), publisher, "English", 0, 416,
                    BindingType.SOFT_COVER, dim, weight, null, "Java best practices",
                    Money.of(new BigDecimal("45.99"), Currency.values()[0]));
            book.addGenre(Genre.NON_FICTION);

            if (!"Effective Java".equals(book.getTitle())) throw new IllegalStateException();
            System.out.println("[VERDE] Book válido: " + book.getTitle()); passed++;
        } catch (Exception e) { System.out.println("[ROJO] " + e.getMessage()); failed++; }

        try {
            Book.of(1L, null, "", null, null, null, "", -1, 0, null, null, null, null, "", null);
            System.out.println("[ROJO] Book inválido aceptado"); failed++;
        } catch (IllegalArgumentException e) { System.out.println("[VERDE] Book inválido rechazado"); passed++; }

        System.out.println("Book: " + passed + " OK, " + failed + " FAIL");
    }
}