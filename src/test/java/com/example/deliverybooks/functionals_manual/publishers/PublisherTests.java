package com.example.deliverybooks.functionals_manual.publishers;

import com.example.deliverybooks.domain.clients.Cif;
import com.example.deliverybooks.domain.publishers.Publisher;
import com.example.deliverybooks.domain.shared.valueobjects.Addressr;
import com.example.deliverybooks.domain.shared.valueobjects.Email;
import com.example.deliverybooks.domain.shared.valueobjects.Phone;
import com.example.deliverybooks.domain.shared.valueobjects.WebSite;

public final class PublisherTests {
    public static void main(String[] args) {
        int passed = 0, failed = 0;

        try {
            Publisher p = Publisher.of(1L, "Nova", new Cif("B87654321"),
                    new Addressr("Travessera de Gràcia 47", "Barcelona", "08021", "España"),
                    new Phone("932001122"), new Email("contacto@nova.es"), WebSite.of("https://penguinlibros.com"));
            if (!"Nova".equals(p.getName())) throw new IllegalStateException();
            System.out.println("[VERDE] Publisher válido: " + p.getName()); passed++;
        } catch (Exception e) { System.out.println("[ROJO] " + e.getMessage()); failed++; }

        try {
            Publisher.of(1L, "", null, null, null, null, null);
            System.out.println("[ROJO] Publisher inválido aceptado"); failed++;
        } catch (IllegalArgumentException e) { System.out.println("[VERDE] Publisher inválido rechazado"); passed++; }

        System.out.println("Publisher: " + passed + " OK, " + failed + " FAIL");
    }
}