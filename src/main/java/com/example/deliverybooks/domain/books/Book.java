package com.example.deliverybooks.domain.books;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.example.deliverybooks.domain.authors.Author;
import com.example.deliverybooks.domain.publishers.Publisher;
import com.example.deliverybooks.domain.shared.validations.Checker;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.Dimensions;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.Weight;
import com.example.deliverybooks.domain.shared.valueobjects.money.Money;

public class Book {
    private final long bookId;
    private Isbn isbn;
    private String title;
    private final Set<Author> authors = new HashSet<>();
    private LocalDate releaseDate;
    private Publisher publisher;
    private String language;
    private int minimumAge;
    private int totalPages;
    private BindingType binding;
    private Dimensions dimensions;
    private Weight weight;
    private Saga saga;
    private String sinopsis;
    private final Set<Genre> genres = new HashSet<>();
    private Money price;

    private Book(long bookId, Isbn isbn, String title, Author author, LocalDate releaseDate,
                 Publisher publisher, String language, int minimumAge, int totalPages,
                 BindingType binding, Dimensions dimensions, Weight weight,
                 Saga saga, String sinopsis, Money price) {
        if (bookId <= 0) throw new IllegalArgumentException("bookId must be positive");
        this.bookId = bookId;
        this.isbn = Checker.notNull(isbn, "isbn");
        this.title = Checker.notEmptyString(title);
        this.authors.add(Checker.notNull(author, "author"));
        this.releaseDate = Checker.notNull(releaseDate, "releaseDate");
        this.publisher = Checker.notNull(publisher, "publisher");
        this.language = Checker.notEmptyString(language);
        this.minimumAge = Checker.nonNegative(minimumAge, "minimumAge");
        this.totalPages = Checker.positiveInt(totalPages, "totalPages");
        this.binding = Checker.notNull(binding, "binding");
        this.dimensions = Checker.notNull(dimensions, "dimensions");
        this.weight = Checker.notNull(weight, "weight");
        this.saga = saga;
        this.sinopsis = sinopsis != null ? sinopsis.trim() : "";
        this.price = Checker.notNull(price, "price");
    }

    public static Book of(long bookId, Isbn isbn, String title, Author author, LocalDate releaseDate,
                          Publisher publisher, String language, int minimumAge, int totalPages,
                          BindingType binding, Dimensions dimensions, Weight weight,
                          Saga saga, String sinopsis, Money price) {
        return new Book(bookId, isbn, title, author, releaseDate, publisher, language,
                minimumAge, totalPages, binding, dimensions, weight, saga, sinopsis, price);
    }

    public long getBookId() { return bookId; }
    public Isbn getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public Set<Author> getAuthors() { return Collections.unmodifiableSet(authors); }
    public LocalDate getReleaseDate() { return releaseDate; }
    public Publisher getPublisher() { return publisher; }
    public String getLanguage() { return language; }
    public int getMinimumAge() { return minimumAge; }
    public int getTotalPages() { return totalPages; }
    public BindingType getBinding() { return binding; }
    public Dimensions getDimensions() { return dimensions; }
    public Weight getWeight() { return weight; }
    public Saga getSaga() { return saga; }
    public String getSinopsis() { return sinopsis; }
    public Set<Genre> getGenres() { return Collections.unmodifiableSet(genres); }
    public Money getPrice() { return price; }

    public void addAuthor(Author author) { authors.add(Checker.notNull(author, "author")); }
    public void addGenre(Genre genre) { genres.add(Checker.notNull(genre, "genre")); }
}