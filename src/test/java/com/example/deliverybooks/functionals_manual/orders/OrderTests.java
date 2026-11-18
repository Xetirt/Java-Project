package com.example.deliverybooks.functionals_manual.orders;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.example.deliverybooks.domain.authors.Author;
import com.example.deliverybooks.domain.books.BindingType;
import com.example.deliverybooks.domain.books.Book;
import com.example.deliverybooks.domain.books.Isbn;
import com.example.deliverybooks.domain.clients.Cif;
import com.example.deliverybooks.domain.clients.Client;
import com.example.deliverybooks.domain.clients.Nif;
import com.example.deliverybooks.domain.orders.Order;
import com.example.deliverybooks.domain.orders.OrderDetails;
import com.example.deliverybooks.domain.publishers.Publisher;
import com.example.deliverybooks.domain.shared.valueobjects.Addressc;
import com.example.deliverybooks.domain.shared.valueobjects.Addressr;
import com.example.deliverybooks.domain.shared.valueobjects.Email;
import com.example.deliverybooks.domain.shared.valueobjects.Phone;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.Dimensions;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.DistanceUnit;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.Weight;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.WeightUnit;
import com.example.deliverybooks.domain.shared.valueobjects.money.Currency;
import com.example.deliverybooks.domain.shared.valueobjects.money.Money;

public class OrderTests {
    @Test
    void shouldCreateValidOrderAndDetails() {
        Client client = Client.of(1L, "Xavier Ramírez", Nif.of("12345678Z"),
                Email.of("xavier@example.com"), Phone.of("600112233"),
                Addressc.of("Carrer Major 10", "Viladecans", "08840", "España"),
                LocalDateTime.of(2007, 5, 10, 12, 0));

        Author author = Author.of(1L, "Joshua Bloch", LocalDate.of(1961, 8, 28), "", null);
        Publisher publisher = Publisher.of(1L, "Addison-Wesley", Cif.of("B12345678"),
                Addressr.of("Calle Gran Via 10", "Madrid", "28013", "España"),
                Phone.of("911234567"), Email.of("info@addison.com"), null);
        Book book = Book.of(1L, Isbn.of("978-0-13-468599-1"), "Effective Java", author,
                LocalDate.of(2018, 1, 6), publisher, "English", 0, 416,
                BindingType.SOFT_COVER,
                Dimensions.of(BigDecimal.TEN, BigDecimal.TEN, BigDecimal.ONE, DistanceUnit.CENTIMETER),
                Weight.of(BigDecimal.ONE, WeightUnit.KILOGRAMS),
                null, "", Money.of(new BigDecimal("45.99"), Currency.values()[0]));

        Order order = Order.of(1L, client, LocalDateTime.now());
        order.addDetail(OrderDetails.of(book, 2, new BigDecimal("45.99")));
        assertEquals(1, order.getBooks().size());
    }

    @Test
    void shouldThrowExceptionWhenOrderOrDetailsAreInvalid() {
        assertThrows(IllegalArgumentException.class, () -> OrderDetails.of(null, 0, BigDecimal.ZERO));
        assertThrows(IllegalArgumentException.class, () -> Order.of(0L, null, null));
    }
}