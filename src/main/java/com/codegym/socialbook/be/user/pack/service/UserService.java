package com.codegym.socialbook.be.user.pack.service;

import com.codegym.socialbook.be.user.pack.model.Users;
import com.codegym.socialbook.be.user.pack.repository.UserRpo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRpo userRepo;

    @Override
    public Page<Users> find12ProvidersSortByStartDate(Pageable page) {
        return userRepo.find12lProvidersSortByStartDate(page);
    }
}
