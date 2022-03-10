package com.codegym.socialbook.be.user.pack.service;

import com.codegym.socialbook.be.user.pack.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IOrderService {
    Page<Orders> findAllRentOrdersForProvider(Pageable page, Long id);
    void save(Orders order);
    void delete(Long id);
    Orders findById(Long id);
    Page<Orders> findAllRentedOrdersForCustomer(Pageable page, Long id);
}
