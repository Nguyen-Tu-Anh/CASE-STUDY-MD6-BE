package com.codegym.socialbook.be.user.pack.service;

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
    public Set<Users> search(SearchForm searchForm) {
        Set<Users> listReturn = new HashSet<>();
        if (searchForm.getName() != null) {
            List<Users> byUserName = findListUsersByName(searchForm.getName());
            for (Users u : byUserName) {
                listReturn.add(u);
            }
        }
        if (searchForm.getCity() != null) {
            List<Users> byAddress = findListUsersByCity(searchForm.getCity());
            for (Users u : byAddress) {
                listReturn.add(u);
            }
        }
        if (searchForm.getAge() != 0) {
            List<Users> byAge = findListUsersByAge(searchForm.getAge());
            for (Users u : byAge) {
                listReturn.add(u);
            }
        }
        if (searchForm.getGender() != null) {
            List<Users> byGender = findListUsersByGender(searchForm.getGender());
            for (Users u : byGender) {
                listReturn.add(u);
            }
        }
        return listReturn;
    }

    @Override
    public List<Users> findListUsersByName(String name) {
        return userRepo.findAllByNameContaining(name);
    }

    @Override
    public List<Users> findListUsersByAge(int age) {
        return userRepo.findAllByAgeContaining(age);
    }

    @Override
    public List<Users> findListUsersByCity(String city) {
        return userRepo.findAllByCityContaining(city);
    }

    @Override
    public List<Users> findListUsersByGender(String gender) {
        return userRepo.findAllByGenderContaining(gender);
    }
}
