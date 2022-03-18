package com.codegym.socialbook.be.user.pack.repository;

import com.codegym.socialbook.be.user.pack.model.Chat;
import com.codegym.socialbook.be.user.pack.model.Orders;
import com.codegym.socialbook.be.user.pack.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IChatRepo extends JpaRepository<Chat,Long> {
    @Query(nativeQuery = true, value = "select * from chat where provider_id =:id order by chat.id desc")
    Page<Chat> findAllComenUser(Pageable page, @Param("id") Long id);



}
