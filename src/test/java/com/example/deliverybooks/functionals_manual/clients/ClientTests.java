package com.example.deliverybooks.functionals_manual.clients;

import java.time.LocalDateTime;
import com.example.deliverybooks.domain.clients.*;
import com.example.deliverybooks.domain.shared.valueobjects.*;

public final class ClientTests {
    public static void main(String[] args) {
        int passed = 0, failed = 0;

        try {
            Client c = Client.of(1L, "Xavier Ramírez", new Nie("X1234567L"),
                    new Email("xavier@example.com"), new Phone("600123456"),
                    new Addressc("Calle Mayor 12", "Viladecans", "08840", "España"),
                    LocalDateTime.of(2007, 5, 10, 10, 0));
            if (!c.getTipoLegalID().startsWith("NIE:")) throw new IllegalStateException();
            System.out.println("[VERDE] Client válido: " + c.getFullname()); passed++;
        } catch (Exception e) { System.out.println("[ROJO] " + e.getMessage()); failed++; }

        try {
            Client.of(0L, "", null, null, null, null, null);
            System.out.println("[ROJO] Client inválido aceptado"); failed++;
        } catch (IllegalArgumentException e) { System.out.println("[VERDE] Client inválido rechazado"); passed++; }

        System.out.println("Client: " + passed + " OK, " + failed + " FAIL");
    }
}
