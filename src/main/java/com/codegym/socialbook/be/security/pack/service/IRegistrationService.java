package com.codegym.socialbook.be.security.pack.service;

import com.codegym.socialbook.be.user.pack.model.Users;
import org.springframework.http.ResponseEntity;

public interface IRegistrationService {
    void register(Users users);

}
