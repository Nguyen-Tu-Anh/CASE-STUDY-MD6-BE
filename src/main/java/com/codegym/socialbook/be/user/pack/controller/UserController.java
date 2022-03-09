package com.codegym.socialbook.be.user.pack.controller;

import com.codegym.socialbook.be.user.pack.model.Users;
import com.codegym.socialbook.be.user.pack.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/home")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping
    public ResponseEntity<Page<Users>> find12lProvidersSortByStartDate(){
        return new ResponseEntity(userService.find12ProvidersSortByStartDate(PageRequest.of(0,12)), HttpStatus.OK);
    }
}
