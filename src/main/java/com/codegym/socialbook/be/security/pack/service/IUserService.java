package com.codegym.socialbook.be.security.pack.service;


import com.codegym.socialbook.be.user.pack.model.Users;

import java.util.Optional;

public interface IUserService {
    Optional<Users> findByUsername(String name); //Tim kiem User co ton tai trong DB khong?
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Users save(Users users);
    Optional<Users> findById(Long id);
}
