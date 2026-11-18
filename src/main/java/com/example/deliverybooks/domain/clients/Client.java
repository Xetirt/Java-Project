package com.example.deliverybooks.domain.clients;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.example.deliverybooks.domain.shared.validations.Check;
import com.example.deliverybooks.domain.shared.valueobjects.Addressc;
import com.example.deliverybooks.domain.shared.valueobjects.Email;
import com.example.deliverybooks.domain.shared.valueobjects.Phone;

public class Client {
    private final long clientID;
    private String fullname;
    private LegalID legalID;
    private Email email;
    private Phone phone;
    private Addressc address;
    private final LocalDateTime registrationDate;
    private LocalDateTime birthDate;

    private static final DateTimeFormatter DEFAULT_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    private Client(long clientID, String fullname, LegalID legalID, Email email, Phone phone,
                   Addressc address, LocalDateTime birthDate) {
        this.clientID = Check.positiveLong(clientID, "clientID");
        this.fullname = Check.minLengthString(fullname, 2);
        this.legalID = Check.notNull(legalID, "legalID");
        this.email = Check.notNull(email, "email");
        this.phone = Check.notNull(phone, "phone");
        this.address = Check.notNull(address, "address");
        this.registrationDate = LocalDateTime.now();
        this.birthDate = Check.notFutureDateTime(birthDate, "birthDate");
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