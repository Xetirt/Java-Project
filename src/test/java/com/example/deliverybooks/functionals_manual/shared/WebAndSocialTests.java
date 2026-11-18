package com.example.deliverybooks.functionals_manual.shared;

import com.example.deliverybooks.domain.shared.valueobjects.SocialMediaProfile;
import com.example.deliverybooks.domain.shared.valueobjects.SocialNetwork;
import com.example.deliverybooks.domain.shared.valueobjects.WebSite;

public final class WebAndSocialTests {
    public static void main(String[] args) {
        int passed = 0, failed = 0;

        try {
            WebSite web = WebSite.of("https://editorial.es");
            SocialMediaProfile smp = SocialMediaProfile.of(SocialNetwork.INSTAGRAM, web);
            if (smp.socialNetwork() != SocialNetwork.INSTAGRAM) throw new IllegalStateException();
            System.out.println("[VERDE] WebSite y SocialMediaProfile válidos"); passed++;
        } catch (Exception e) { System.out.println("[ROJO] " + e.getMessage()); failed++; }

        try {
            WebSite.of("url-sin-protocolo");
            System.out.println("[ROJO] URL inválida aceptada"); failed++;
        } catch (IllegalArgumentException e) { System.out.println("[VERDE] URL inválida rechazada"); passed++; }

        try {
            SocialMediaProfile.of(null, WebSite.of("https://editorial.es"));
            System.out.println("[ROJO] Red social nula aceptada"); failed++;
        } catch (IllegalArgumentException e) { System.out.println("[VERDE] Red social nula rechazada"); passed++; }

        System.out.println("Web & Social: " + passed + " OK, " + failed + " FAIL");
    }
}