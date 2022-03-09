package com.codegym.socialbook.be.user.pack.controller;


import com.codegym.socialbook.be.user.pack.model.Users;
import com.codegym.socialbook.be.user.pack.services.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    IUsersService usersService;

    @GetMapping("")
    public ResponseEntity<List<Users>> getAll() {
        return new ResponseEntity(usersService.findAll(), HttpStatus.OK);
    }

}
