package com.example.demo.bean;


import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @Column(name = "iduser", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int iduser;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "userRole")
    private UserRole userRole;



    private enum UserRole {
        user, admin
    }
}
