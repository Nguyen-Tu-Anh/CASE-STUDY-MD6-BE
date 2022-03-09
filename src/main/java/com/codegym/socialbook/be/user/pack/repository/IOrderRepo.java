package com.codegym.socialbook.be.user.pack.repository;

import com.codegym.socialbook.be.user.pack.model.Orders;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IOrderRepo extends JpaRepository<Orders, Long> {
    @Query("select o from Orders o where o.status = 1 order by o.dateOfOrder desc ")
    Page<Orders> findAllRentOrders(Pageable page);
}
