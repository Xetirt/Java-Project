package com.example.deliverybooks.domain.authors;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import com.example.deliverybooks.domain.books.Book;
import com.example.deliverybooks.domain.books.Genre;
import com.example.deliverybooks.domain.books.Saga;
import com.example.deliverybooks.domain.shared.validations.Checker;
import com.example.deliverybooks.domain.shared.valueobjects.SocialMediaProfile;
import com.example.deliverybooks.domain.shared.valueobjects.WebSite;

public class Author {
    private final long authorId;
    private String fullName;
    private LocalDate birthdate;
    private String biography;
    private WebSite webSite;
    private final Set<Book> bibliography = new HashSet<>();
    private final Set<Genre> genres = new HashSet<>();
    private final Set<Saga> sagas = new HashSet<>();
    private final Set<SocialMediaProfile> profiles = new HashSet<>();

    private Author(long authorId, String fullName, LocalDate birthdate, String biography, WebSite webSite) {
        if (authorId <= 0) throw new IllegalArgumentException("authorId must be positive");
        this.authorId = authorId;
        this.fullName = Checker.minLengthString(fullName, 2);
        this.birthdate = Checker.notNull(birthdate, "birthdate");
        this.biography = biography != null ? biography.trim() : "";
        this.webSite = webSite;
    }

    public static Author of(long authorId, String fullName, LocalDate birthdate, String biography, WebSite webSite) {
        return new Author(authorId, fullName, birthdate, biography, webSite);
    }

    public long getAuthorId() { return authorId; }
    public String getFullName() { return fullName; }
    public LocalDate getBirthdate() { return birthdate; }
    public String getBiography() { return biography; }
    public WebSite getWebSite() { return webSite; }
    public Set<Book> getBibliography() { return Collections.unmodifiableSet(bibliography); }
    public Set<Genre> getGenres() { return Collections.unmodifiableSet(genres); }
    public Set<Saga> getSagas() { return Collections.unmodifiableSet(sagas); }
    public Set<SocialMediaProfile> getProfiles() { return Collections.unmodifiableSet(profiles); }

    public void addBook(Book book) { bibliography.add(Checker.notNull(book, "book")); }
    public void addGenre(Genre genre) { genres.add(Checker.notNull(genre, "genre")); }
    public void addSaga(Saga saga) { sagas.add(Checker.notNull(saga, "saga")); }
    public void addProfile(SocialMediaProfile profile) { profiles.add(Checker.notNull(profile, "profile")); }
}