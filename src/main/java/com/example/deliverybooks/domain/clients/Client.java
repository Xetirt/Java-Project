package com.example.deliverybooks.domain.clients;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.deliverybooks.domain.shared.validations.Checker;
import com.example.deliverybooks.domain.shared.valueobjects.Addressc;
import com.example.deliverybooks.domain.shared.valueobjects.Email;
import com.example.deliverybooks.domain.shared.valueobjects.Phone;

public class Client {
    private long clientID;
    private String fullname;
    private LegalID legalID;
    private Email email;
    private Phone phone;
    private Addressc address;
    private LocalDateTime registrationDate;
    private LocalDateTime birthDate;

    private static final DateTimeFormatter DEFAULT_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public Client(long clientID, String fullname, LegalID legalID, Email email, Phone phone,
                  Addressc address, LocalDateTime birthDate) {
        if (clientID <= 0) throw new IllegalArgumentException("clientID must be positive");
        this.clientID = clientID;
        this.fullname = Checker.minLengthString(fullname, 2);
        this.legalID = Checker.notNull(legalID, "legalID");
        this.email = Checker.notNull(email, "email");
        this.phone = Checker.notNull(phone, "phone");
        this.address = Checker.notNull(address, "address");
        this.registrationDate = LocalDateTime.now();
        this.birthDate = birthDate;
    }

    public static Client of(long clientID, String fullname, LegalID legalID, Email email, Phone phone,
                            Addressc address, LocalDateTime birthDate) {
        return new Client(clientID, fullname, legalID, email, phone, address, birthDate);
    }

    public long getClientID() { return clientID; }
    public String getFullname() { return fullname; }
    public LegalID getLegalID() { return legalID; }
    public Email getEmail() { return email; }
    public Phone getPhone() { return phone; }
    public Addressc getAddress() { return address; }
    public LocalDateTime getRegistrationDate() { return registrationDate; }
    public LocalDateTime getBirthDate() { return birthDate; }

    public String getTipoLegalID() {
        return switch (legalID) {
            case Nif n -> "NIF: " + n.getLegalID();
            case Cif c -> "CIF: " + c.getLegalID();
            case Nie nie -> "NIE: " + nie.getLegalID();
        };
    }

    public String getNie() {
        return (this.legalID instanceof Nie nie) ? nie.getLegalID() : "";
    }

    public String getFormattedRegistrationDate() {
        return registrationDate != null ? registrationDate.format(DEFAULT_FORMAT) : "N/A";
    }

    public String getFormattedBirthDate() {
        return birthDate != null ? birthDate.format(DEFAULT_FORMAT) : "N/A";
    }
}