package com.example.demo.bean;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "ORDER")
public class Order {

    @Column(name = "idorder")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "user_iduser")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "book_idbook")
    private Book book;

    @Column
    private String description;

    @Column(name="date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;

}
