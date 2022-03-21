package com.codegym.socialbook.be.user.pack.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private double point;
    @ManyToOne
    private Users users;
}
