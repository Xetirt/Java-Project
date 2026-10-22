package com.example.deliverybooks.domain.clients;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

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
        this.clientID = clientID;
        this.fullname = Objects.requireNonNull(fullname, "El nombre completo no puede ser nulo");
        this.legalID = Objects.requireNonNull(legalID, "El identificador legal no puede ser nulo");
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.registrationDate = LocalDateTime.now();
        this.birthDate = birthDate;
    }

    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = Objects.requireNonNull(fullname, "El nombre completo no puede ser nulo");
    }

    public LegalID getLegalID() {
        return legalID;
    }

    public void setLegalID(LegalID legalID) {
        this.legalID = Objects.requireNonNull(legalID, "El identificador legal no puede ser nulo");
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Addressc getAddress() {
        return address;
    }

    public void setAddress(Addressc address) {
        this.address = address;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Procesa el tipo de identificador legal mediante Pattern Matching exhaustivo.
     */
    public String getTipoLegalID() {
        return switch (legalID) {
            case Nif n -> "NIF: " + n.getLegalID();
            case Cif c -> "CIF: " + c.getLegalID();
            case Nie nie -> "NIE: " + nie.getLegalID();
        };
    }

    /**
     * Devuelve el valor del NIE únicamente si el cliente posee un identificador de tipo Nie.
     */
    public String getNie() {
        // Pattern Matching seguro para verificar si legalID es una instancia de Nie
        if (this.legalID instanceof Nie nie) {
            return nie.getLegalID();
        }
        return "";
    }

    public String getFormattedRegistrationDate() {
        return registrationDate != null ? registrationDate.format(DEFAULT_FORMAT) : "N/A";
    }

    public String getFormattedBirthDate() {
        return birthDate != null ? birthDate.format(DEFAULT_FORMAT) : "N/A";
    }
}