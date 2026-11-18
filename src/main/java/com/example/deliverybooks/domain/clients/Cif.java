package com.example.deliverybooks.domain.clients;

import java.util.Objects;
import com.example.deliverybooks.domain.shared.validations.Check;

public final class Nif implements LegalID {
    private final String legalID;

    private Nif(String legalID) {
        String normalized = Check.notEmptyString(legalID).toUpperCase();
        if (!normalized.matches("^[0-9]{8}[A-Z]$")) {
            throw new IllegalArgumentException("Invalid NIF format: " + legalID);
        }
        this.legalID = normalized;
    }

    public static Nif of(String legalID) {
        return new Nif(legalID);
    }

    @Override
    public String getLegalID() { return legalID; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(legalID, ((Nif) o).legalID);
    }

    @Override
    public int hashCode() { return Objects.hash(legalID); }

    @Override
    public String toString() { return "NIF{" + legalID + '}'; }
}