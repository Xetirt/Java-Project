package com.example.deliverybooks.functionals_manual.shared;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.example.deliverybooks.domain.shared.valueobjects.SocialMediaProfile;
import com.example.deliverybooks.domain.shared.valueobjects.SocialNetwork;
import com.example.deliverybooks.domain.shared.valueobjects.WebSite;

public class WebAndSocialTests {
    @Test
    void shouldCreateValidWebSiteAndProfile() {
        WebSite web = WebSite.of("https://editorial.es");
        SocialMediaProfile profile = SocialMediaProfile.of(SocialNetwork.INSTAGRAM, web);
        assertEquals("https://editorial.es", web.url());
        assertEquals(SocialNetwork.INSTAGRAM, profile.socialNetwork());
    }

    @Test
    void shouldThrowExceptionWhenWebSiteOrProfileIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> WebSite.of(null));
        assertThrows(IllegalArgumentException.class, () -> WebSite.of("url-sin-protocolo"));
        assertThrows(IllegalArgumentException.class, () -> SocialMediaProfile.of(null, WebSite.of("https://editorial.es")));
        assertThrows(IllegalArgumentException.class, () -> SocialMediaProfile.of(SocialNetwork.YOUTUBE, null));
    }
}