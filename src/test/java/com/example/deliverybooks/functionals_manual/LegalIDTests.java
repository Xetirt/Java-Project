package com.example.deliverybooks.functionals_manual;

import com.example.deliverybooks.domain.clients.Cif;
import com.example.deliverybooks.domain.clients.LegalID;
import com.example.deliverybooks.domain.clients.Nie;
import com.example.deliverybooks.domain.clients.Nif;

public final class LegalIDTests {
    private LegalIDTests() {}
    public static void main(String[] args) {
        LegalID[] ids = {new Nif("12345678A"), new Cif("A12345678"), new Nie("X1234567L")};
        String[] expected = {"12345678A", "A12345678", "X1234567L"};
        for (int i = 0; i < ids.length; i++) {
            if (!expected[i].equals(ids[i].getLegalID())) throw new IllegalStateException("LegalID distinto en índice " + i);
        }
        System.out.println("[VERDE] Polimorfismo LegalID verificado.");
    }
}
