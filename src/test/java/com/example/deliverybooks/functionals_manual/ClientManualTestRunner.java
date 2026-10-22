package com.example.deliverybooks.functionals_manual;

import java.time.LocalDateTime;

import com.example.deliverybooks.domain.clients.Client;
import com.example.deliverybooks.domain.clients.Nie;
import com.example.deliverybooks.domain.shared.valueobjects.Addressc;
import com.example.deliverybooks.domain.shared.valueobjects.Email;
import com.example.deliverybooks.domain.shared.valueobjects.Phone;

public class ClientManualTestRunner {

    public static void main(String[] args) {

        try {
            // Value Objects iniciales
            Nie nie = new Nie("X1234567L");
            Email email = new Email("cliente@example.com");
            Phone phone = new Phone("600123456");

            Addressc address = new Addressc(
                "Calle Mayor 12",
                "Madrid",
                "28001",
                "España"
            );

            // Cliente instanciado sin atributo de peso
            Client client = new Client(
                1L,
                "Xavier Ramirez",
                nie,
                email,
                phone,
                address,
                LocalDateTime.of(2001, 10, 14, 10, 30)
            );

            // Mostrar todos los datos del cliente
            System.out.println("===== DATOS DEL CLIENTE =====");
            System.out.println("NIE: " + client.getNie());
            System.out.println("Tipo Legal ID: " + client.getTipoLegalID());
            System.out.println("ID: " + client.getClientID());
            System.out.println("Fullname: " + client.getFullname());
            System.out.println("Email: " + client.getEmail());
            System.out.println("Phone: " + client.getPhone());
            System.out.println("Street address: " + client.getAddress());
            System.out.println("Registration date: " + client.getRegistrationDate());
            System.out.println("Registration date (Formatted): " + client.getFormattedRegistrationDate());
            System.out.println("Birthdate: " + client.getBirthDate());
            System.out.println("Birthdate (Formatted): " + client.getFormattedBirthDate());

            // Comprobación de campos obligatorios
            if (client.getNie().isEmpty()
                    || client.getEmail() == null
                    || client.getPhone() == null
                    || client.getAddress() == null) {
                throw new IllegalStateException(
                    "Hay campos obligatorios sin completar"
                );
            }

            System.out.println("=============================");
            System.out.println("[VERDE] Cliente creado correctamente");

        } catch (Exception e) {
            System.err.println("[ROJO] Error al crear el cliente: "
                    + e.getMessage());
            throw new IllegalStateException("Test del cliente fallido", e);
        }
    }
}