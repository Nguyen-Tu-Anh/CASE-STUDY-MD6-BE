package com.codegym.socialbook.be.user.pack.dto.request;

import com.codegym.socialbook.be.user.pack.model.Image;
import com.codegym.socialbook.be.user.pack.model.ServiceOfProvider;
import lombok.Data;

import javax.persistence.ManyToMany;
import java.sql.Date;
import java.util.Set;

@Data
public class UpdateUserDTO {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String avatar;
    private String phoneNumber;
    private int age;
    private String gender;
    private Date dateOfBirth;
    private String city;
    private String nationality;
    private String description;
    private String requirement;
    private String identify;
    @ManyToMany
    private Set<Image> images;
}
