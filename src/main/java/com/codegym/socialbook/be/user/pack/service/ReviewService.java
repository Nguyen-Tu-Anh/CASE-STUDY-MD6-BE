package com.codegym.socialbook.be.user.pack.service;

import com.codegym.socialbook.be.user.pack.model.Orders;
import com.codegym.socialbook.be.user.pack.model.Review;
import com.codegym.socialbook.be.user.pack.model.Users;
import com.codegym.socialbook.be.user.pack.repository.IReviewRepo;
import com.codegym.socialbook.be.user.pack.repository.IUserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements IReviewService{
    @Autowired
    IReviewRepo reviewRepo;

    @Autowired
    IUserService userService;

    @Override
    public Page<Review> findAllComenUser(Pageable page, Long id) {
        return reviewRepo.findAllComenUser(page, id);
    }

    @Override
    public void addNewReview(Review review, Long id) {
        Users users = userService.findById(id);
        review.setUsers(users);
        reviewRepo.save(review);
    }


//    @Override
//    public void addNewReview(Review review, Long id) {
//        Users user = userService.findById(id);
//        user.getReviews().add(review);
//        reviewRepo.save(review);
//    }

    @Override
    public void deleteReview(Long id) {
        reviewRepo.deleteById(id);
    }
}
