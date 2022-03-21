package com.codegym.socialbook.be.user.pack.service;

import com.codegym.socialbook.be.security.pack.model.Role;
import com.codegym.socialbook.be.security.pack.model.RoleName;
import com.codegym.socialbook.be.user.pack.dto.request.SearchForm;
import com.codegym.socialbook.be.user.pack.model.Users;
import com.codegym.socialbook.be.user.pack.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements IUserService {
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
    public Page<Users> find12ProvidersSortByCountOfDate(Pageable page) {
        return userRepo.find12MostDatedProvider(page);
    }

    @Override
    public Page<Users> showALl(Pageable page) {
        return userRepo.findAll(page);
    }


    @Override
    public Page<Users> search(SearchForm searchForm, Pageable page) {
        int maxAge = searchForm.getMaxAge();
        int minAge = searchForm.getMinAge();
        String name = searchForm.getName();
        String city = searchForm.getCity();
        String gender = searchForm.getGender();
        return userRepo.searchProvider(maxAge, minAge, name, city, gender, page);
    }

    @Override
    public void removeAdmin(Long id) {
        Users user = findById(id);
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            if (role.getId() == 3) {
                roles.remove(role);
                break;
            }
        }
        user.setRoles(roles);
        save(user);
    }

    @Override
    public void makeAdmin(Long id) {
        Users user = findById(id);
        Set<Role> roles = user.getRoles();
        roles.add(new Role(3L, RoleName.ADMIN));
        user.setRoles(roles);
        save(user);
    }

//    @Override
//    public List<Users> findListUsersByName(String name) {
//        return userRepo.findAllByNameContaining(name);
//    }
//
//    @Override
//    public List<Users> findListUsersByAge(int maxAge, int minAge) {
//        return userRepo.findAllByAgeContaining(maxAge, minAge);
//    }
//
//    @Override
//    public List<Users> findListUsersByCity(String city) {
//        return userRepo.findAllByCityContaining(city);
//    }
//
//    @Override
//    public List<Users> findListUsersByGender(String gender) {
//        return userRepo.findAllByGenderContaining(gender);
//    }
}

