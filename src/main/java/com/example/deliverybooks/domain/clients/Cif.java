package com.example.deliverybooks.domain.clients;

import java.util.Objects;

/**
 * Representación inmutable del CIF (Persona Jurídica).
 */
public final class Cif implements LegalID {
    private final String legalID;

    public Cif(String legalID) {
        this.legalID = Objects.requireNonNull(legalID, "El CIF no puede ser nulo");
    }

    @Override
    public String getLegalID() {
        return legalID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cif cif = (Cif) o;
        return Objects.equals(legalID, cif.legalID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(legalID);
    }

    @Override
    public String toString() {
        return "CIF{" + legalID + '}';
    }
}