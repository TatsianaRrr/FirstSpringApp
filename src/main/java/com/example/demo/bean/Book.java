package com.example.demo.bean;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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

  /*  @Column(name = "publishing_house")
    private String publishingHouse;*/

    @Column(name = "year")
    private int year;

    @Column(name = "genre")
    private String genre;

    @Column(name = "country")
    private String country;

    @Column(name = "isbn")
    private long isbn;

  /*  @Column(name = "countOfPages")
    private int countOfPages;*/

    @Column(name = "language")
    private String language;

   /* @Column(name = "author_of_translation")
    private String authorOfTranslation;*/

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "delete")
    private boolean delete;

    @Column(name = "image")
    private String image;

   /* @OneToMany(
            mappedBy = "book",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }*/

    public long getIdbook() {
        return idbook;
    }

    public void setIdbook(int idbook) {
        this.idbook = idbook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

 /*   public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }*/

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

  /*  public int getCountOfPages() {
        return countOfPages;
    }

    public void setCountOfPages(int countOfPages) {
        this.countOfPages = countOfPages;
    }*/

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

   /* public String getAuthorOfTranslation() {
        return authorOfTranslation;
    }

    public void setAuthorOfTranslation(String authorOfTranslation) {
        this.authorOfTranslation = authorOfTranslation;
    }*/

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



}
