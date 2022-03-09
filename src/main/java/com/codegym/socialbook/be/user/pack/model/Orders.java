package com.codegym.socialbook.be.user.pack.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name="orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double priceOfHour;
    private Date dateOfOrder;
    private double hoursOfService;
    private int status;
    private long customerId;
}
