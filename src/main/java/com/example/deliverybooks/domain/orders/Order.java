package com.example.deliverybooks.domain.orders;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.example.deliverybooks.domain.clients.Client;
import com.example.deliverybooks.domain.shared.validations.Check;

public class Order {
    private final long id;
    private final Client client;
    private final LocalDateTime orderTime;
    private final Set<OrderDetails> books = new HashSet<>();

    private Order(long id, Client client, LocalDateTime orderTime) {
        this.id = Check.positiveLong(id, "id");
        this.client = Check.notNull(client, "client");
        this.orderTime = Check.notNull(orderTime, "orderTime");
    }

    public static Order of(long id, Client client, LocalDateTime orderTime) {
        return new Order(id, client, orderTime);
    }

    public long getId() { return id; }
    public Client getClient() { return client; }
    public LocalDateTime getOrderTime() { return orderTime; }
    public Set<OrderDetails> getBooks() { return Collections.unmodifiableSet(books); }

    public void addDetail(OrderDetails detail) { books.add(Check.notNull(detail, "detail")); }
}