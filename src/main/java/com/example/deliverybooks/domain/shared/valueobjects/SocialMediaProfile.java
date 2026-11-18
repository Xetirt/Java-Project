package com.example.deliverybooks.domain.shared.valueobjects;

import com.example.deliverybooks.domain.shared.validations.Checker;

public record SocialMediaProfile(SocialNetwork socialNetwork, WebSite url) {
    public SocialMediaProfile {
        Checker.notNull(socialNetwork, "SocialNetwork");
        Checker.notNull(url, "WebSite");
    }

    public static SocialMediaProfile of(SocialNetwork socialNetwork, WebSite url) {
        return new SocialMediaProfile(socialNetwork, url);
    }
}