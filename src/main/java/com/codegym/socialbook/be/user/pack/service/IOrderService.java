package com.codegym.socialbook.be.user.pack.service;

import com.codegym.socialbook.be.user.pack.model.Orders;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    List<Orders> findAllByCustomerId(Long id);
    List<Orders> findAllByProviderId(Long id);
    Orders save(Orders order);
    Optional<Orders> findById(Long id);
    void deleteById(Long id);
}
