package com.codegym.socialbook.be.user.pack.service;

import com.codegym.socialbook.be.user.pack.model.Chat;
import com.codegym.socialbook.be.user.pack.model.Orders;
import com.codegym.socialbook.be.user.pack.repository.IChatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    IChatRepo chatRepo;



    public Page<Chat> findAllComenUser(Pageable page,Long id) {
        return chatRepo.findAllComenUser(page,id);
    }


    public void save(Chat chat) {
        chatRepo.save(chat);
    }


    public void delete(Long id) {
        chatRepo.deleteById(id);
    }

}
