package com.codegym.socialbook.be.user.pack.service;

import com.codegym.socialbook.be.user.pack.model.Orders;
import com.codegym.socialbook.be.user.pack.repository.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService{
    @Autowired
    IOrderRepo orderRepo;
    @Override
    public List<Orders> findAllByCustomerId(Long id) {
        return orderRepo.findAllByCustomerId(id);
    }

    @Override
    public List<Orders> findAllByProviderId(Long id) {
        return orderRepo.findAllByProviderId(id);
    }

    @Override
    public Orders save(Orders order) {
        return orderRepo.save(order);
    }

    @Override
    public Optional<Orders> findById(Long id) {
        return orderRepo.findById(id);
    }

    @Override
    public void deleteById(Long id) {

    }
}
