package com.example.deliverybooks.functionals_manual.authors;

import java.time.LocalDate;
import com.example.deliverybooks.domain.authors.Author;
import com.example.deliverybooks.domain.books.Genre;
import com.example.deliverybooks.domain.shared.valueobjects.*;

public final class AuthorTests {
    public static void main(String[] args) {
        int passed = 0, failed = 0;

        try {
            Author a = Author.of(1L, "Brandon Sanderson", LocalDate.of(1975, 12, 19), "Autor de fantasía", WebSite.of("https://brandonsanderson.com"));
            a.addGenre(Genre.FANTASY);
            a.addProfile(SocialMediaProfile.of(SocialNetwork.YOUTUBE, WebSite.of("https://youtube.com")));
            if (a.getGenres().size() != 1) throw new IllegalStateException();
            System.out.println("[VERDE] Author válido: " + a.getFullName()); passed++;
        } catch (Exception e) { System.out.println("[ROJO] " + e.getMessage()); failed++; }

        try {
            Author.of(-1L, "A", null, null, null);
            System.out.println("[ROJO] Author inválido aceptado"); failed++;
        } catch (IllegalArgumentException e) { System.out.println("[VERDE] Author inválido rechazado"); passed++; }

        System.out.println("Author: " + passed + " OK, " + failed + " FAIL");
    }
}