package com.codegym.socialbook.be.user.pack.repository;

import com.codegym.socialbook.be.user.pack.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepo extends JpaRepository<Orders, Long> {
    @Query(nativeQuery = true, value = "select * from orders where customer_id = :id")
    List<Orders> findAllByCustomerId(@Param("id") Long id);

    @Query(nativeQuery = true, value = "select * from orders where provider_id = :id")
    List<Orders> findAllByProviderId(@Param("id") Long id);
}
