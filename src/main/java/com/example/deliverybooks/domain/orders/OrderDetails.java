package com.example.deliverybooks.domain.orders;

import java.math.BigDecimal;
import com.example.deliverybooks.domain.books.Book;
import com.example.deliverybooks.domain.shared.validations.Checker;

public class OrderDetails {
    private final Book book;
    private final Integer quantity;
    private final BigDecimal salePrice;

    private OrderDetails(Book book, Integer quantity, BigDecimal salePrice) {
        this.book = Checker.notNull(book, "book");
        Checker.notNull(quantity, "quantity");
        Checker.positiveInt(quantity, "quantity");
        this.quantity = quantity;
        this.salePrice = Checker.positive(salePrice, "salePrice");
    }

    public static OrderDetails of(Book book, Integer quantity, BigDecimal salePrice) {
        return new OrderDetails(book, quantity, salePrice);
    }

    public Book getBook() { return book; }
    public Integer getQuantity() { return quantity; }
    public BigDecimal getSalePrice() { return salePrice; }
}