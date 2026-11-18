package com.example.deliverybooks.functionals_manual.authors;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import com.example.deliverybooks.domain.authors.Author;
import com.example.deliverybooks.domain.books.Genre;
import com.example.deliverybooks.domain.shared.valueobjects.*;

public class AuthorTests {
    @Test
    void shouldCreateValidAuthor() {
        Author author = Author.of(
                1L,
                "Brandon Sanderson",
                LocalDate.of(1975, 12, 19),
                "Autor de fantasía",
                WebSite.of("https://brandonsanderson.com")
        );
        author.addGenre(Genre.FANTASY);
        author.addProfile(SocialMediaProfile.of(SocialNetwork.YOUTUBE, WebSite.of("https://youtube.com")));
        assertEquals("Brandon Sanderson", author.getFullName());
        assertEquals(1, author.getGenres().size());
    }

    @Test
    void shouldThrowExceptionWhenAuthorDataIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> Author.of(-1L, "Brandon", LocalDate.of(1975, 12, 19), "", null));
        assertThrows(IllegalArgumentException.class, () -> Author.of(1L, "A", null, null, null));
    }
}