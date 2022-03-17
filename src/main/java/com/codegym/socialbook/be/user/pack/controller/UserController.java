package com.codegym.socialbook.be.user.pack.controller;

import com.codegym.socialbook.be.user.pack.dto.request.SearchForm;
import com.codegym.socialbook.be.user.pack.dto.request.UpdateProviderDTO;
import com.codegym.socialbook.be.user.pack.dto.request.UpdateUserDTO;
import com.codegym.socialbook.be.user.pack.model.Users;
import com.codegym.socialbook.be.user.pack.service.DTOService;
import com.codegym.socialbook.be.user.pack.service.IOrderService;
import com.codegym.socialbook.be.user.pack.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    IOrderService orderService;

    @Autowired
    DTOService dtoService;



    //lấy ra list 12 người cung cấp dịch vụ sắp xếp theo ngày đăng kí từ mới tới cũ
    @GetMapping("/hot/providers/{page}")
    public ResponseEntity<Page<Users>> find12lProvidersSortByStartDate(@PathVariable int page) {
        return new ResponseEntity(userService.find12ProvidersSortByStartDate(PageRequest.of(page, 12)), HttpStatus.OK);
    }

    // Trả về 1 đối tượng user
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


    //update profile cho provider
    @PutMapping("/provider")
    public ResponseEntity updateProvider(@RequestBody UpdateProviderDTO provider) {
        Users oldProvider = userService.findById(provider.getId());
        oldProvider = dtoService.transferDataFromProviderToOldProvider(oldProvider, provider);
        userService.save(oldProvider);
        return new ResponseEntity(HttpStatus.OK);
    }

    //update profile cho user
    @PutMapping("/user")
    public ResponseEntity updateUser(@RequestBody UpdateUserDTO user) {
        Users oldUser = userService.findById(user.getId());
        oldUser = dtoService.transferDataFromUserToOldUser(oldUser, user);
        userService.save(oldUser);
        return new ResponseEntity(HttpStatus.OK);
    }

    //chuyển trạng thái hoạt động
    @GetMapping("/status/{id}")
    public ResponseEntity<Integer> changeStatus(@PathVariable Long id) {
        Users provider = userService.findById(id);
        if (provider.getStatus() == 1) {
            provider.setStatus(2);
        } else {
            provider.setStatus(1);
        }
        return new ResponseEntity(provider.getStatus(), HttpStatus.OK);
    }

    // 12 provider nhiều lượt date nhất
    @GetMapping("/most/date/provider/{page}")
    public ResponseEntity<Page<Users>> getMostDateProvider(@PathVariable int page) {
        return new ResponseEntity(userService.find12ProvidersSortByCountOfDate(PageRequest.of(page, 12)), HttpStatus.OK);
    }

    //show All
    @GetMapping("/page/{page}")
    public ResponseEntity<Page<Users>> showAll(@PathVariable int page) {
        return new ResponseEntity(userService.showALl(PageRequest.of(page, 12)), HttpStatus.OK);
    }

    //tìm kiếm theo trường
    @PostMapping  ("/search/{page}")
    public ResponseEntity<Page<Users>> findAllByFilters(@RequestBody SearchForm searchForm,@PathVariable int page){
        return new ResponseEntity(userService.search(searchForm,PageRequest.of(page,12)), HttpStatus.OK);
    }

    //Ban 1 user
    @GetMapping("/ban/{id}")
    public ResponseEntity banUser(@PathVariable Long id){
        Users user = userService.findById(id);
        user.setStatus(3);
        userService.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    //Unban 1 user
    @GetMapping("/unban/{id}")
    public ResponseEntity unBanUser(@PathVariable Long id){
        Users user = userService.findById(id);
        user.setStatus(1);
        userService.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }

//    //chuyển trạng thái hoạt động
//    @GetMapping("/status/{id}")
//    public ResponseEntity<Integer> changeStatus(@PathVariable Long id){
//        Users provider = userService.findById(id);
//        if(provider.getStatus()==1){
//            provider.setStatus(2);
//        } else{
//            provider.setStatus(1);
//        }
//        return new ResponseEntity(provider.getStatus(),HttpStatus.OK);
//    }

}
