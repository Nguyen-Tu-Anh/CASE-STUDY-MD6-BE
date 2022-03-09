package com.codegym.socialbook.be.user.pack.controller;

import com.codegym.socialbook.be.user.pack.model.Orders;
import com.codegym.socialbook.be.user.pack.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/order")
public class OrderController {
    @Autowired
    IOrderService orderService;

    //Tìm kiếm list đơn được đặt
    @GetMapping("/rented-orders/{page}")
    public ResponseEntity<Page<Orders>> findAllRentOrders(@PathVariable int page){
        return new ResponseEntity(orderService.findAllRentOrders(PageRequest.of(page,12)), HttpStatus.OK);
    }

    //Xem chi tiết đơn
    @GetMapping("/{id}")
    public ResponseEntity<Orders> findOrderById(@PathVariable Long id){
        return new ResponseEntity(orderService.findById(id), HttpStatus.OK);
    }

    //Xác nhận đơn
    @PutMapping("/{id}")
    public ResponseEntity<Orders> changeStatusToOk(@PathVariable Long id){
        Orders order = orderService.findById(id);
        order.setStatus(2);
        orderService.save(order);
        return new ResponseEntity(order,HttpStatus.OK);
    }
}
