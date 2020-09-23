package com.example.demo.bean;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order")
public class Order {

    @Column(name = "idorder")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   /* @ManyToOne()
    @JoinColumn(name = "user_iduser")
    private User user;*/

    @ManyToOne()
    @JoinColumn(name = "book_idbook")
    private Book book;

    @Column
    private String description;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   /* public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(user, order.user) && Objects.equals(book, order.book) && Objects.equals(description, order.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, book, description);
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(book, order.book) && Objects.equals(description, order.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book, description);
    }
}
