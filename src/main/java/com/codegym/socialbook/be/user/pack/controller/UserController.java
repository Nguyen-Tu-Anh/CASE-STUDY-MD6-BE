package com.codegym.socialbook.be.user.pack.controller;

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
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    IOrderService orderService;

    //lấy ra list 12 người cung cấp dịch vụ sắp xếp theo ngày đăng kí từ mới tới cũ
    @GetMapping("/hot/providers/{page}")
    public ResponseEntity<Page<Users>> find12lProvidersSortByStartDate(@PathVariable int page){
        return new ResponseEntity(userService.find12ProvidersSortByStartDate(PageRequest.of(page,12)), HttpStatus.OK);
    }

    // Trả về 1 đối tượng user
    @GetMapping("/{id}")
    public ResponseEntity<Users> findById(@PathVariable Long id){
        return new ResponseEntity(userService.findById(id),HttpStatus.OK);
    }

    //Chuyển trạng thái
    @PutMapping("/provider/change/{id}")
    public ResponseEntity changeStatusToOffline(@PathVariable Long id){
        Users user = userService.findById(id);
        user.setStatus(2);
        userService.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    //update user
//    @PutMapping("/update")
//    public ResponseEntity updateUser(@RequestBody Users user){
//        if(user.getPassword() == null) {
//            user.setPassword(user.getId());
//        }
//        userService.save(user);
//        return new ResponseEntity(HttpStatus.OK);
//    }
//    //Tìm kiếm theo tên
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@RequestBody Users user, @PathVariable Long id) {

        Users currentUser = userService.findById(id);
        if(user.getPassword() == null) {
            user.setPassword(currentUser.getPassword());
        }
        userService.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }

}
