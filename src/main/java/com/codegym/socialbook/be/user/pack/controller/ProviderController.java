package com.codegym.socialbook.be.user.pack.controller;

import com.codegym.socialbook.be.security.pack.service.IUserService;
import com.codegym.socialbook.be.user.pack.model.Orders;
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
    @GetMapping("/{id}/showAll")
    public ResponseEntity<?> findAllOrderByProviderId(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.findAllByProviderId(id), HttpStatus.OK);
    }

    @PostMapping("/accept")
    public ResponseEntity<?> acceptOrder(@RequestBody Orders order) {
        order.setStatus("accepted");
        return new ResponseEntity<>(orderService.save(order),HttpStatus.OK);
    }

    @PostMapping("/reject")
    public ResponseEntity<?> rejectOrder(@RequestBody Orders order) {
        order.setStatus("rejected");
        return new ResponseEntity<>(orderService.save(order),HttpStatus.OK);
    }
}
