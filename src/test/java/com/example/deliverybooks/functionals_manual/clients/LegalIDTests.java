package com.example.deliverybooks.functionals_manual.clients;

import com.example.deliverybooks.domain.clients.Cif;
import com.example.deliverybooks.domain.clients.LegalID;
import com.example.deliverybooks.domain.clients.Nie;
import com.example.deliverybooks.domain.clients.Nif;

public final class LegalIDTests {
    public static void main(String[] args) {
        int passed = 0, failed = 0;

        try {
            LegalID[] ids = {new Nif("12345678A"), new Cif("A12345678"), new Nie("X1234567L")};
            if (ids.length != 3) throw new IllegalStateException();
            System.out.println("[VERDE] NIF, CIF y NIE válidos"); passed++;
        } catch (Exception e) { System.out.println("[ROJO] " + e.getMessage()); failed++; }

        try { new Nif(null); failed++; } catch (NullPointerException e) { passed++; }
        try { new Cif(null); failed++; } catch (NullPointerException e) { passed++; }
        try { new Nie(null); failed++; } catch (NullPointerException e) { passed++; }
        System.out.println("[VERDE] Nulos en LegalID rechazados");

        System.out.println("LegalID: " + passed + " OK, " + failed + " FAIL");
    }
}