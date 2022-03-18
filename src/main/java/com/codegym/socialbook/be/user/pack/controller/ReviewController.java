package com.codegym.socialbook.be.user.pack.controller;

import com.codegym.socialbook.be.user.pack.model.Chat;
import com.codegym.socialbook.be.user.pack.model.Orders;
import com.codegym.socialbook.be.user.pack.model.Review;
import com.codegym.socialbook.be.user.pack.model.Users;
import com.codegym.socialbook.be.user.pack.service.ChatService;
import com.codegym.socialbook.be.user.pack.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/riview")

public class ReviewController {

    @Autowired
    ReviewService reviewService;


    @Autowired
    ChatService chatService;


    //show All comen provider
    @GetMapping("/{id}/chat/{page}")
    public ResponseEntity<Page<Chat>> showAll( @PathVariable int page,@PathVariable Long id) {
        return new ResponseEntity(chatService.findAllComenUser(PageRequest.of(page, 4),id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Chat> saveComen(@RequestBody Chat chat){
        chatService.save(chat);
        return new ResponseEntity(chat,HttpStatus.OK);
    }

    //Xóa comment
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        chatService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
