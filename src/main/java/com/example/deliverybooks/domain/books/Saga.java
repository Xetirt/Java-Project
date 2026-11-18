package com.example.deliverybooks.domain.books;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.deliverybooks.domain.shared.validations.Check;

public class Saga {
    private final long sagaId;
    private String name;
    private String description;
    private final List<Book> books = new ArrayList<>();
    private final Set<Genre> genres = new HashSet<>();

    private Saga(long sagaId, String name, String description) {
        this.sagaId = Check.positiveLong(sagaId, "sagaId");
        this.name = Check.minLengthString(name, 2);
        this.description = description != null ? description.trim() : "";
    }

    public static Saga of(long sagaId, String name, String description) {
        return new Saga(sagaId, name, description);
    }

    public long getSagaId() { return sagaId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public List<Book> getBooks() { return Collections.unmodifiableList(books); }
    public Set<Genre> getGenres() { return Collections.unmodifiableSet(genres); }

    public void addBook(Book book) { books.add(Check.notNull(book, "book")); }
    public void addGenre(Genre genre) { genres.add(Check.notNull(genre, "genre")); }
}