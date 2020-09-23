package com.example.demo.bean;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "USER")
public class User {
    @Id
    @Column(name = "iduser", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long iduser;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

   /* @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Order> orders;*/


   /* @Enumerated(EnumType.ORDINAL)
    @Column(name = "userRole")
    private UserRole userRole;


    private enum UserRole {
        USER,
        ADMIN;
    }*/


}

