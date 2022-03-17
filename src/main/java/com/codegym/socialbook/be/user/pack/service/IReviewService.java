package com.codegym.socialbook.be.user.pack.service;

import com.codegym.socialbook.be.user.pack.model.Orders;
import com.codegym.socialbook.be.user.pack.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IReviewService {

    public Page<Review> findAllComenUser(Pageable page,Long id) ;
    void addNewReview(Review review, Long id);
    void deleteReview(Long id);

}
