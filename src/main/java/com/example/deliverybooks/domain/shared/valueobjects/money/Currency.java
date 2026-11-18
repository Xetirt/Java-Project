package com.example.deliverybooks.domain.shared.valueobjects.money;

public enum Currency {
    EUR("€"),
    USD("$"),
    GBP("£");

    private final String symbol;

    Currency(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}