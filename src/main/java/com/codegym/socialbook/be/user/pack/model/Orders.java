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
    private Long id;
    private double priceOfHour;
    private Date dateOfOrder;
    private double hoursOfService;

    //1 : Chờ phản hồi
    //2 : Đã nhận
    //3 : Hoàn thành
    private int status;
    private long customerId;
    private Long providerId;
}
