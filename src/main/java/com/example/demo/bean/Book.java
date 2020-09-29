package com.example.demo.bean;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @Column(name = "idbook", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idbook;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

  /* @Column(name = "publishingHouse")
    private String publishingHouse;*/

    @Column(name = "year")
    private int year;

    @Column(name = "genre")
    private String genre;

    @Column(name = "country")
    private String country;

    @Column(name = "isbn")
    private long isbn;

  /*  @Column(name = "countOgPages")
    private Integer countOfPages;*/

    @Column(name = "language")
    private String language;

   /* @Column(name = "authorOfTranslation")
    private String authorOfTranslation;*/

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "delete")
    private boolean delete;

    @Column(name = "image")
    private String image;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "order",
            joinColumns = {@JoinColumn(name = "book_idbook")},
            inverseJoinColumns = {@JoinColumn(name = "user_iduser")}
    )
    private Set<User> users = new HashSet<>();

}
