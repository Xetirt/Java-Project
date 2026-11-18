package com.example.deliverybooks.domain.books;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.example.deliverybooks.domain.authors.Author;
import com.example.deliverybooks.domain.publishers.Publisher;
import com.example.deliverybooks.domain.shared.validations.Check;
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
        this.bookId = Check.positiveLong(bookId, "bookId");
        this.isbn = Check.notNull(isbn, "isbn");
        this.title = Check.notEmptyString(title);
        this.authors.add(Check.notNull(author, "author"));
        this.releaseDate = Check.notNull(releaseDate, "releaseDate");
        this.publisher = Check.notNull(publisher, "publisher");
        this.language = Check.notEmptyString(language);
        this.minimumAge = Check.nonNegative(minimumAge, "minimumAge");
        this.totalPages = Check.positiveInt(totalPages, "totalPages");
        this.binding = Check.notNull(binding, "binding");
        this.dimensions = Check.notNull(dimensions, "dimensions");
        this.weight = Check.notNull(weight, "weight");
        this.saga = saga;
        this.sinopsis = sinopsis != null ? sinopsis.trim() : "";
        this.price = Check.notNull(price, "price");
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

    public void addAuthor(Author author) { authors.add(Check.notNull(author, "author")); }
    public void addGenre(Genre genre) { genres.add(Check.notNull(genre, "genre")); }
}