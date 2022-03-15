package com.codegym.socialbook.be.user.pack.dto.request;

import lombok.Data;

@Data
public class SearchForm {
    private String name;
    private int age;
    private String gender;
    private String city;
}
