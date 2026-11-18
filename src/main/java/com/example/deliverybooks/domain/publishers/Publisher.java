package com.example.deliverybooks.domain.publishers;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.example.deliverybooks.domain.books.Book;
import com.example.deliverybooks.domain.clients.LegalID;
import com.example.deliverybooks.domain.shared.validations.Checker;
import com.example.deliverybooks.domain.shared.valueobjects.Addressr;
import com.example.deliverybooks.domain.shared.valueobjects.Email;
import com.example.deliverybooks.domain.shared.valueobjects.Phone;
import com.example.deliverybooks.domain.shared.valueobjects.SocialMediaProfile;
import com.example.deliverybooks.domain.shared.valueobjects.WebSite;

public class Publisher {
    private final long publisherId;
    private String name;
    private LegalID legalId;
    private Addressr address;
    private Phone phone;
    private Email email;
    private WebSite webSite;
    private final Set<Book> books = new HashSet<>();
    private final Set<SocialMediaProfile> profiles = new HashSet<>();

    private Publisher(long publisherId, String name, LegalID legalId, Addressr address,
                      Phone phone, Email email, WebSite webSite) {
        if (publisherId <= 0) throw new IllegalArgumentException("publisherId must be positive");
        this.publisherId = publisherId;
        this.name = Checker.minLengthString(name, 2);
        this.legalId = Checker.notNull(legalId, "legalId");
        this.address = Checker.notNull(address, "address");
        this.phone = Checker.notNull(phone, "phone");
        this.email = Checker.notNull(email, "email");
        this.webSite = webSite;
    }

    public static Publisher of(long publisherId, String name, LegalID legalId, Addressr address,
                               Phone phone, Email email, WebSite webSite) {
        return new Publisher(publisherId, name, legalId, address, phone, email, webSite);
    }

    public long getPublisherId() { return publisherId; }
    public String getName() { return name; }
    public LegalID getLegalId() { return legalId; }
    public Addressr getAddress() { return address; }
    public Phone getPhone() { return phone; }
    public Email getEmail() { return email; }
    public WebSite getWebSite() { return webSite; }
    public Set<Book> getBooks() { return Collections.unmodifiableSet(books); }
    public Set<SocialMediaProfile> getProfiles() { return Collections.unmodifiableSet(profiles); }

    public void addBook(Book book) { books.add(Checker.notNull(book, "book")); }
    public void addProfile(SocialMediaProfile profile) { profiles.add(Checker.notNull(profile, "profile")); }
}