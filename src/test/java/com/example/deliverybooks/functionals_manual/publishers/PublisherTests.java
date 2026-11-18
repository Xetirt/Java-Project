package com.example.deliverybooks.functionals_manual.publishers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.example.deliverybooks.domain.clients.Cif;
import com.example.deliverybooks.domain.publishers.Publisher;
import com.example.deliverybooks.domain.shared.valueobjects.Addressr;
import com.example.deliverybooks.domain.shared.valueobjects.Email;
import com.example.deliverybooks.domain.shared.valueobjects.Phone;
import com.example.deliverybooks.domain.shared.valueobjects.WebSite;

public class PublisherTests {
    @Test
    void shouldCreateValidPublisher() {
        Publisher publisher = Publisher.of(
                1L,
                "Nova",
                Cif.of("B87654321"),
                Addressr.of("Travessera de Gràcia 47", "Barcelona", "08021", "España"),
                Phone.of("932001122"),
                Email.of("contacto@nova.es"),
                WebSite.of("https://penguinlibros.com")
        );
        assertEquals("Nova", publisher.getName());
    }

    @Test
    void shouldThrowExceptionWhenPublisherDataIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> Publisher.of(0L, "Nova", null, null, null, null, null));
        assertThrows(IllegalArgumentException.class, () -> Publisher.of(1L, "", null, null, null, null, null));
    }
}