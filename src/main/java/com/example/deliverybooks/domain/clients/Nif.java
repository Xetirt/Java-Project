package com.example.deliverybooks.domain.clients;

import java.util.Objects;

/**
 * Representación inmutable del NIF (Persona Física).
 */
public final class Nif implements LegalID {
    private final String legalID;

    public Nif(String legalID) {
        this.legalID = Objects.requireNonNull(legalID, "El NIF no puede ser nulo");
    }

    @Override
    public String getLegalID() {
        return legalID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nif nif = (Nif) o;
        return Objects.equals(legalID, nif.legalID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(legalID);
    }

    @Override
    public String toString() {
        return "NIF{" + legalID + '}';
    }
}