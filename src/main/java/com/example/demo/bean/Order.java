package com.example.demo.bean;

import javax.persistence.*;

@Entity(name = "order")
@Table(name = "order")
public class Order {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    User user;

    @ManyToOne
    @JoinColumn(name = "bookId")
    Book book;

    @Column
    private String description;

    public Order() {
    }
}
