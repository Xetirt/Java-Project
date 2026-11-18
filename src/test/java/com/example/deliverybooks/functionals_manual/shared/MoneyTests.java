package com.example.deliverybooks.functionals_manual.shared;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.example.deliverybooks.domain.shared.valueobjects.money.Currency;
import com.example.deliverybooks.domain.shared.valueobjects.money.Money;

public class MoneyTests {
    @Test
    void shouldCreateValidMoney() {
        Currency currency = Currency.values()[0];
        Money money = Money.of(new BigDecimal("24.99"), currency);
        assertEquals(new BigDecimal("24.99"), money.value());
        assertEquals(currency, money.currency());
    }

    @Test
    void shouldThrowExceptionWhenMoneyIsInvalid() {
        Currency currency = Currency.values()[0];
        assertThrows(IllegalArgumentException.class, () -> Money.of(new BigDecimal("-1"), currency));
        assertThrows(IllegalArgumentException.class, () -> Money.of(null, currency));
        assertThrows(IllegalArgumentException.class, () -> Money.of(BigDecimal.TEN, null));
    }
}