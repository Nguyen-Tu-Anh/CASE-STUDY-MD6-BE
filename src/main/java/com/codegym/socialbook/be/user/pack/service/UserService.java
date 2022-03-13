package com.codegym.socialbook.be.user.pack.service;

import com.codegym.socialbook.be.user.pack.model.Users;
import com.codegym.socialbook.be.user.pack.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepo userRepo;

    @Override
    public Page<Users> find12ProvidersSortByStartDate(Pageable page) {
        return userRepo.find12lProvidersSortByStartDate(page);
    }

    @Override
    public Users findById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void save(Users user) {
        userRepo.save(user);
    }

    @Override
    public Users getUserByUserName(String username) {
        return userRepo.getUserByUserName(username);
    }
}
