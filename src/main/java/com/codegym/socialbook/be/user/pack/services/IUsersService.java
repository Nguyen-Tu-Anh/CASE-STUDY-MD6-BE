package com.codegym.socialbook.be.user.pack.services;

import com.codegym.socialbook.be.user.pack.model.Users;

import java.util.List;

public interface IUsersService {
   List<Users> findAll();
   Users findById(Long id);
   Users save(Users users);
   void delete(Long id);
}
