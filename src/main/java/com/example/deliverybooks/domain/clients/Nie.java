package com.example.deliverybooks.domain.clients;

import java.util.Objects;

import com.example.deliverybooks.domain.shared.validations.Check;

public final class Nie implements LegalID {
    private final String legalID;

    private Nie(String legalID) {
        String normalized = Check.notEmptyString(legalID).toUpperCase();
        if (!normalized.matches("^[XYZ][0-9]{7}[A-Z]$")) {
            throw new IllegalArgumentException("Invalid NIE format: " + legalID);
        }
        this.legalID = normalized;
    }

    public static Nie of(String legalID) {
        return new Nie(legalID);
    }

    @Override
    public String getLegalID() { return legalID; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(legalID, ((Nie) o).legalID);
    }

    @Override
    public int hashCode() { return Objects.hash(legalID); }

    @Override
    public String toString() { return "NIE{" + legalID + '}'; }
}