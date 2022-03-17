package com.codegym.socialbook.be.user.pack.service;

import com.codegym.socialbook.be.security.pack.model.Role;
import com.codegym.socialbook.be.security.pack.model.RoleName;
import com.codegym.socialbook.be.user.pack.dto.request.UpdateProviderDTO;
import com.codegym.socialbook.be.user.pack.dto.request.UpdateUserDTO;
import com.codegym.socialbook.be.user.pack.model.Users;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DTOService {

    public Users transferDataFromProviderToOldProvider(Users olProvider, UpdateProviderDTO provider) {
        olProvider.setName(provider.getName());
        olProvider.setAge(provider.getAge());
        olProvider.setAvatar(provider.getAvatar());
        olProvider.setUsername(provider.getUsername());
        olProvider.setEmail(provider.getEmail());
        if (provider.getPassword() != null) {
            olProvider.setPassword(provider.getPassword());
        }
        olProvider.setPhoneNumber(provider.getPhoneNumber());
        olProvider.setGender(provider.getGender());
        olProvider.setDateOfBirth(provider.getDateOfBirth());
        olProvider.setCity(provider.getCity());
        olProvider.setNationality(provider.getNationality());
        olProvider.setDescription(provider.getDescription());
        olProvider.setRequirement(provider.getRequirement());
        olProvider.setFacebookUrl(provider.getFacebookUrl());
        olProvider.setIdentify(provider.getIdentify());
        olProvider.setPrice(provider.getPrice());
        olProvider.setServiceOfProviders(provider.getServiceOfProviders());
        olProvider.setImages(provider.getImages());
        Set<Role> roles = olProvider.getRoles();
        Boolean status = true;
        for (Role r : roles) {
            if (r.getId() == 2)
                status = false;
        }
        if (status) roles.add(new Role(2L, RoleName.SP));
        olProvider.setRoles(roles);
        return olProvider;
    }

    public Users transferDataFromUserToOldUser(Users oldUser, UpdateUserDTO user) {
        oldUser.setName(user.getName());
        oldUser.setUsername(user.getUsername());
        oldUser.setEmail(user.getEmail());
        if (user.getPassword() != null) {
            oldUser.setPassword(user.getPassword());
        }
        oldUser.setAvatar(user.getAvatar());
        oldUser.setDateOfBirth(user.getDateOfBirth());
        oldUser.setGender(user.getGender());
        oldUser.setPhoneNumber(user.getPhoneNumber());
        oldUser.setAge(user.getAge());
        oldUser.setCity(user.getCity());
        oldUser.setNationality(user.getNationality());
        oldUser.setDescription(user.getDescription());
        oldUser.setRequirement(user.getRequirement());
        oldUser.setIdentify(user.getIdentify());
        oldUser.setImages(user.getImages());
        return oldUser;
    }
}
