package com.example.deliverybooks.functionals_manual.orders;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

public final class OrderTests {
    public static void main(String[] args) {
        int passed = 0, failed = 0;

        try {
            Client client = Client.of(1L, "Xavier Ramírez", new Nif("12345678Z"),
                    new Email("xavier@example.com"), new Phone("600112233"),
                    new Addressc("Carrer Major 10", "Viladecans", "08840", "España"),
                    LocalDateTime.of(2007, 5, 10, 12, 0));

            Author author = Author.of(1L, "Joshua Bloch", LocalDate.of(1961, 8, 28), "", null);
            Publisher publisher = Publisher.of(1L, "Addison-Wesley", new Cif("B12345678"),
                    new Addressr("Calle Gran Via 10", "Madrid", "28013", "España"),
                    new Phone("911234567"), new Email("info@addison.com"), null);
            Book book = Book.of(1L, Isbn.of("978-0-13-468599-1"), "Effective Java", author,
                    LocalDate.of(2018, 1, 6), publisher, "English", 0, 416,
                    BindingType.SOFT_COVER,
                    new Dimensions(BigDecimal.TEN, BigDecimal.TEN, BigDecimal.ONE, DistanceUnit.CENTIMETER),
                    new Weight(BigDecimal.ONE, WeightUnit.KILOGRAMS),
                    null, "", Money.of(new BigDecimal("45.99"), Currency.values()[0]));

            Order order = Order.of(1L, client, LocalDateTime.now());
            order.addDetail(OrderDetails.of(book, 2, new BigDecimal("45.99")));

            if (order.getBooks().size() != 1) throw new IllegalStateException();
            System.out.println("[VERDE] Order y OrderDetails válidos"); passed++;
        } catch (Exception e) { System.out.println("[ROJO] " + e.getMessage()); failed++; }

        try {
            OrderDetails.of(null, 0, BigDecimal.ZERO);
            System.out.println("[ROJO] OrderDetails inválido aceptado"); failed++;
        } catch (IllegalArgumentException e) { System.out.println("[VERDE] OrderDetails inválido rechazado"); passed++; }

        try {
            Order.of(0L, null, null);
            System.out.println("[ROJO] Order inválido aceptado"); failed++;
        } catch (IllegalArgumentException e) { System.out.println("[VERDE] Order inválido rechazado"); passed++; }

        System.out.println("Order: " + passed + " OK, " + failed + " FAIL");
    }
}