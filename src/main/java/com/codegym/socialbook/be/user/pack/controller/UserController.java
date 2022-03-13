package com.codegym.socialbook.be.user.pack.controller;

import com.codegym.socialbook.be.security.pack.dto.request.UserDto;
import com.codegym.socialbook.be.user.pack.model.Orders;
import com.codegym.socialbook.be.user.pack.model.Users;
import com.codegym.socialbook.be.user.pack.service.IOrderService;
import com.codegym.socialbook.be.user.pack.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/home")
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    IOrderService orderService;

    //lấy ra list 12 người cung cấp dịch vụ
    @GetMapping("/hot/providers")
    public ResponseEntity<Page<Users>> find12lProvidersSortByStartDate() {
        return new ResponseEntity(userService.find12ProvidersSortByStartDate(PageRequest.of(0, 12)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> findById(@PathVariable Long id) {
        return new ResponseEntity(userService.findById(id), HttpStatus.OK);
    }

    //Chuyển trạng thái
    @PutMapping("/provider/change/{id}")
    public ResponseEntity changeStatusToOffline(@PathVariable Long id) {
        Users user = userService.findById(id);
        user.setStatus(2);
        userService.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    //update user
    @PutMapping()
    public ResponseEntity updateUser(@RequestBody UserDto userDto) {
       Users currentUser = userService.getUserByUserName(userDto.getName());
        if(userDto.getPassword() != null) {
            currentUser.setPassword(userDto.getPassword());
        }
        userService.save(currentUser);
        return new ResponseEntity(HttpStatus.OK);
    }

    //Tìm kiếm list đơn được đặt
    @GetMapping("/rented-orders/{page}")
    public ResponseEntity<Page<Orders>> findAllRentOrders(@PathVariable int page) {
        return new ResponseEntity(orderService.findAllRentOrders(PageRequest.of(page, 12)), HttpStatus.OK);
    }

}
