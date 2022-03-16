package com.codegym.socialbook.be.user.pack.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class SearchForm {
    private String name;
    private int maxAge;
    private int minAge;
    private String gender;
    private String city;
}
