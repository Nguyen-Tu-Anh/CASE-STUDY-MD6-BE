package com.codegym.socialbook.be.user.pack.controller;

import com.codegym.socialbook.be.security.pack.service.IUserService;
import com.codegym.socialbook.be.user.pack.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/providers")
public class ProviderController {
    @Autowired
    IOrderService orderService;
    @GetMapping("/{id}")
    public ResponseEntity<?> findAllOrderByProviderId(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.findAllByProviderId(id), HttpStatus.OK);
    }
}
