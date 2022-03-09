package com.codegym.socialbook.be.user.pack.service;

import com.codegym.socialbook.be.user.pack.model.Orders;
import com.codegym.socialbook.be.user.pack.repository.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService{
    @Autowired
    IOrderRepo orderRepo;

    @Override
    public Page<Orders> findAllRentOrders(Pageable page) {
        return orderRepo.findAllRentOrders(page);
    }
}
