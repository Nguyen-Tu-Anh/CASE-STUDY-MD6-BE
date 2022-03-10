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
    public Page<Orders> findAllRentOrdersForProvider(Pageable page, Long id) {
        return orderRepo.findAllRentOrdersForProvider(page,id);
    }

    @Override
    public void save(Orders order) {
        orderRepo.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepo.deleteById(id);
    }

    @Override
    public Orders findById(Long id) {
        return orderRepo.findById(id).get();
    }

    @Override
    public Page<Orders> findAllRentedOrdersForCustomer(Pageable page, Long id) {
        return null;
    }
}
