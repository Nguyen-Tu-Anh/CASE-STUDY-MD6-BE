package com.codegym.socialbook.be.security.pack.service.impl;

import com.codegym.socialbook.be.security.pack.dto.response.ResponseMessage;
import com.codegym.socialbook.be.security.pack.service.IEmailSender;
import com.codegym.socialbook.be.security.pack.service.IRegistrationService;
import com.codegym.socialbook.be.security.pack.service.IUserService;
import com.codegym.socialbook.be.user.pack.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements IRegistrationService {
    @Autowired
    IUserService userService;
    @Autowired
    IEmailSender emailSender;
    @Override
    public void register(Users users) {
        userService.save(users);
        String emailTo = users.getEmail();
        String body = "Successful account registration, welcome to Player Dou";
        String title = "Hi, i'm Player Duo";
        emailSender.send(emailTo,body,title);
    }
}
