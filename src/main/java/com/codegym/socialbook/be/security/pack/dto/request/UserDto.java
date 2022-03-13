package com.codegym.socialbook.be.security.pack.dto.request;

import com.codegym.socialbook.be.security.pack.model.Role;
import com.codegym.socialbook.be.user.pack.model.Orders;
import com.codegym.socialbook.be.user.pack.model.Review;
import com.codegym.socialbook.be.user.pack.model.ServiceOfProvider;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String avatar;
    Set<Role> roles = new HashSet<>();
    private String phoneNumber;
    private int age;
    private String gender;
    private String dateOfBirth;
    private String city;
    private String nationality;
    private int status;
    private String description;
    private String requirement;
    private Date startDate;
    private Date vipDate;
    private String facebookUrl;
    private Long countOfDate;
    private String identify;
    private Set<String> images;
    private Role role;
    private double price;
    private Set<ServiceOfProvider> serviceOfProviders;
    private Set<Review> reviews;
    private Set<Orders> orders;

}
