package com.codegym.socialbook.be.user.pack.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;

    @ManyToOne
    Users customer;

    @ManyToOne
    Users nccdv;
}
