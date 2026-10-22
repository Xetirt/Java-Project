package com.example.deliverybooks.domain.books;

import java.math.BigDecimal;
import java.util.Objects;

import com.example.deliverybooks.domain.shared.valueobjects.mesurament.Weight;

public class Book {

    private String isbn;
    private String title;
    private String author;
    private BigDecimal price;
    private Weight weight; // Integración del Value Object Weight para el peso del libro

    public Book(String isbn, String title, String author, BigDecimal price, Weight weight) {
        this.isbn = Objects.requireNonNull(isbn, "ISBN cannot be null");
        this.title = Objects.requireNonNull(title, "Title cannot be null");
        this.author = Objects.requireNonNull(author, "Author cannot be null");
        this.price = Objects.requireNonNull(price, "Price cannot be null");
        this.weight = Objects.requireNonNull(weight, "Weight cannot be null");
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = Objects.requireNonNull(isbn, "ISBN cannot be null");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = Objects.requireNonNull(title, "Title cannot be null");
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = Objects.requireNonNull(author, "Author cannot be null");
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = Objects.requireNonNull(price, "Price cannot be null");
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = Objects.requireNonNull(weight, "Weight cannot be null");
    }
}