package com.codegym.socialbook.be.user.pack.services;

import com.codegym.socialbook.be.user.pack.model.Users;
import com.codegym.socialbook.be.user.pack.repositorys.IUsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsersService implements  IUsersService{
    @Autowired
    IUsersRepo iUsersRepo;

    @Override
    public List<Users> findAll() {
        return (List<Users>) iUsersRepo.findAll();
    }

    @Override
    public Users findById(Long id) {
        return iUsersRepo.findById(id).get();
    }

    @Override
    public Users save(Users users) {
        return iUsersRepo.save(users);
    }

    @Override
    public void delete(Long id) {
        iUsersRepo.deleteById(id);
    }
}
