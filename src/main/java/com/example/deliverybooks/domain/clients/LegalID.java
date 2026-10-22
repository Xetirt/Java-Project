package com.example.deliverybooks.domain.clients;

public sealed interface LegalID permits Nif, Cif, Nie {
    String getLegalID();
}