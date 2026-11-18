package com.example.deliverybooks.domain.shared.valueobjects;

import com.example.deliverybooks.domain.shared.validations.Check;

public record SocialMediaProfile(SocialNetwork socialNetwork, WebSite url) {
    public SocialMediaProfile {
        Check.notNull(socialNetwork, "SocialNetwork");
        Check.notNull(url, "WebSite");
    }

    public static SocialMediaProfile of(SocialNetwork socialNetwork, WebSite url) {
        return new SocialMediaProfile(socialNetwork, url);
    }
}