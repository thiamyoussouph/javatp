package com.myapp.mywebapp;

import javax.persistence.*;

@Entity
@Table
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false ,unique = true)
    private String email;
    @Column(length = 15,nullable = false)
    private  String password;
    @Column(length = 15,nullable = false)
    private  String nom;
    @Column(length = 15,nullable = false)
    private String prenon;


}
