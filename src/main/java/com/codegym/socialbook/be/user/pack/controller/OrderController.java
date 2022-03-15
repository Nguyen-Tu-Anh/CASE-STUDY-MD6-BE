package com.codegym.socialbook.be.user.pack.controller;

import com.codegym.socialbook.be.user.pack.model.Orders;
import com.codegym.socialbook.be.user.pack.model.Users;
import com.codegym.socialbook.be.user.pack.service.IOrderService;
import com.codegym.socialbook.be.user.pack.service.IUserService;
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

    @Autowired
    IUserService userService;

    //Tìm kiếm list đơn được đặt
    @GetMapping("/{id}/provider/{page}")
    public ResponseEntity<Page<Orders>> findAllRentOrdersForProvider(@PathVariable int page,@PathVariable Long id){
        return new ResponseEntity(orderService.findAllRentOrdersForProvider(PageRequest.of(page,12),id), HttpStatus.OK);
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
        Users provider = userService.findById(order.getProviderId());
        provider.setCountOfDate(provider.getCountOfDate()+1);
        userService.save(provider);
        return new ResponseEntity(order,HttpStatus.OK);
    }

    // Xóa đơn
    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrder(@PathVariable Long id){
        orderService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    //Tạo đơn
    @PostMapping()
    public ResponseEntity<Orders> makeNewOrder(@RequestBody Orders order){
        orderService.save(order);
        return new ResponseEntity(order,HttpStatus.OK);
    }

    //Danh sách đơn của khách
    @GetMapping("/{id}/customer/{page}")
    public ResponseEntity<Page<Orders>> findAllRentedOrdersForCustomer(@PathVariable long id,@PathVariable int page){
        return new ResponseEntity(orderService.findAllRentedOrdersForCustomer(PageRequest.of(page,12),id),HttpStatus.OK);
    }
}
