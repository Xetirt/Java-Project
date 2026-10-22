package com.example.deliverybooks.functionals_manual.books;

import java.math.BigDecimal;

import com.example.deliverybooks.domain.books.Book;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.Weight;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.WeightUnit;

public class BookManualTestRunner {

    public static void main(String[] args) {

        try {
            // Se crea el peso del libro recibido en Libras (ej. 1.5 lbs)
            Weight bookWeight = new Weight(new BigDecimal("1.5"), WeightUnit.POUNDS);

            // Instancia del libro con su peso correspondiente
            Book book = new Book(
                "978-0-13-468599-1",
                "Effective Java",
                "Joshua Bloch",
                new BigDecimal("45.99"),
                bookWeight
            );

            // Mostrar datos del libro
            System.out.println("===== DATOS DEL LIBRO =====");
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Price: $" + book.getPrice());

            // Mostrar el peso y las conversiones explícitas de Weight / WeightUnit
            System.out.println("--- DETALLES DEL PESO (WEIGHT & WEIGHTUNIT) ---");
            // Muestra el valor guardado internamente en gramos
            System.out.println("Internal Base Value : " + book.getWeight().value() + " " + book.getWeight().unit());
            System.out.println("Weight in Grams     : " + book.getWeight().getValueIn(WeightUnit.GRAMS) + " g");
            System.out.println("Weight in Ounces    : " + book.getWeight().getValueIn(WeightUnit.OUNCES) + " oz");
            System.out.println("Weight in Pounds    : " + book.getWeight().getValueIn(WeightUnit.POUNDS) + " lbs");
            System.out.println("Weight in Kilograms : " + book.getWeight().getValueIn(WeightUnit.KILOGRAMS) + " kg");
            System.out.println("Weight in Tonnes    : " + book.getWeight().getValueIn(WeightUnit.TONNES) + " t");

            // Comprobación de campos obligatorios
            if (book.getIsbn() == null 
                    || book.getTitle() == null 
                    || book.getAuthor() == null 
                    || book.getPrice() == null 
                    || book.getWeight() == null) {
                throw new IllegalStateException("Hay campos obligatorios del libro sin completar");
            }

            System.out.println("=============================");
            System.out.println("[VERDE] Libro creado y verificado correctamente");

        } catch (Exception e) {
            System.err.println("[ROJO] Error al crear el libro: " + e.getMessage());
            throw new IllegalStateException("Test del libro fallido", e);
        }
    }
}