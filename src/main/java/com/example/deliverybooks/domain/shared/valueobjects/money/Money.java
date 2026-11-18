package com.example.deliverybooks.domain.shared.valueobjects.money;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.example.deliverybooks.domain.shared.validations.Check;

public record Money(BigDecimal value, Currency currency) {
    public Money {
        Check.nonNegative(value, "Amount");
        Check.notNull(currency, "Currency");
        value = value.setScale(2, RoundingMode.HALF_UP);
    }

    public static Money of(BigDecimal value, Currency currency) {
        return new Money(value, currency);
    }

    @Override
    public String toString() {
        return value + " " + currency.getSymbol();
    }
}