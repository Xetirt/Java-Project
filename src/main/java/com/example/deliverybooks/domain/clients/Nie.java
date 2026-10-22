package com.example.deliverybooks.domain.clients;

import java.util.Objects;

/**
 * Representación inmutable del NIE (Residente Extranjero).
 */
public final class Nie implements LegalID {
    private final String legalID;

    public Nie(String legalID) {
        this.legalID = Objects.requireNonNull(legalID, "El NIE no puede ser nulo");
    }

    @Override
    public String getLegalID() {
        return legalID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nie nie = (Nie) o;
        return Objects.equals(legalID, nie.legalID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(legalID);
    }

    @Override
    public String toString() {
        return "NIE{" + legalID + '}';
    }
}