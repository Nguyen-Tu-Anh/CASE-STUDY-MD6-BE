package com.codegym.socialbook.be.user.pack.repository;

import com.codegym.socialbook.be.user.pack.model.Chat;
import com.codegym.socialbook.be.user.pack.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IReviewRepo extends JpaRepository<Review, Long> {

    @Query(nativeQuery = true, value = "select * from review r join users u on r.users_id = u.id where u.id=:id")
    Page<Review> findAllComenUser(Pageable page, @Param("id") Long id);


}
