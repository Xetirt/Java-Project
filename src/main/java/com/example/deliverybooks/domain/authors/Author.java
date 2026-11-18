package com.example.deliverybooks.domain.authors;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.example.deliverybooks.domain.books.Book;
import com.example.deliverybooks.domain.books.Genre;
import com.example.deliverybooks.domain.books.Saga;
import com.example.deliverybooks.domain.shared.validations.Check;
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
        this.authorId = Check.positiveLong(authorId, "authorId");
        this.fullName = Check.minLengthString(fullName, 2);
        this.birthdate = Check.notFutureDate(birthdate, "birthdate");
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

    public void addBook(Book book) { bibliography.add(Check.notNull(book, "book")); }
    public void addGenre(Genre genre) { genres.add(Check.notNull(genre, "genre")); }
    public void addSaga(Saga saga) { sagas.add(Check.notNull(saga, "saga")); }
    public void addProfile(SocialMediaProfile profile) { profiles.add(Check.notNull(profile, "profile")); }
}