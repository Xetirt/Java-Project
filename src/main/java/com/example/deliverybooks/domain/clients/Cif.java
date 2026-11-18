package com.example.deliverybooks.domain.clients;

import java.util.Objects;
import com.example.deliverybooks.domain.shared.validations.Check;

public final class Cif implements LegalID {
    private final String legalID;

    private Cif(String legalID) {
        String normalized = Check.notEmptyString(legalID).toUpperCase();
        if (!normalized.matches("^[ABCDEFGHJKLMNPQRSUVW][0-9]{7}[0-9A-J]$")) {
            throw new IllegalArgumentException("Invalid CIF format: " + legalID);
        }
        this.legalID = normalized;
    }

    public static Cif of(String legalID) {
        return new Cif(legalID);
    }

    @Override
    public String getLegalID() { return legalID; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(legalID, ((Cif) o).legalID);
    }

    @Override
    public int hashCode() { return Objects.hash(legalID); }

    @Override
    public String toString() { return "CIF{" + legalID + '}'; }
}