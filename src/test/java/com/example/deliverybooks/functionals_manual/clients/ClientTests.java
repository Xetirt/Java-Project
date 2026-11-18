package com.example.deliverybooks.functionals_manual.clients;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import com.example.deliverybooks.domain.clients.*;
import com.example.deliverybooks.domain.shared.valueobjects.*;

public class ClientTests {
    @Test
    void shouldCreateValidClient() {
        Client client = Client.of(
                1L,
                "Xavier Ramírez",
                Nie.of("X1234567L"),
                Email.of("xavier@example.com"),
                Phone.of("600123456"),
                Addressc.of("Calle Mayor 12", "Viladecans", "08840", "España"),
                LocalDateTime.of(2007, 5, 10, 10, 0)
        );
        assertEquals("Xavier Ramírez", client.getFullname());
        assertEquals("NIE: X1234567L", client.getTipoLegalID());
    }

    @Test
    void shouldThrowExceptionWhenClientDataIsInvalid() {
        assertThrows(IllegalArgumentException.class, () ->
                Client.of(0L, "Xavier", Nif.of("12345678A"), Email.of("xavier@example.com"),
                        Phone.of("600123456"), Addressc.of("Calle Mayor 12", "Viladecans", "08840", "España"),
                        LocalDateTime.of(2007, 5, 10, 10, 0))
        );
        assertThrows(IllegalArgumentException.class, () ->
                Client.of(1L, "", null, null, null, null, null)
        );
    }
}