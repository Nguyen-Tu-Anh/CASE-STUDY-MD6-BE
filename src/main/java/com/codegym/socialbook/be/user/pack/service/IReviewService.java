package com.codegym.socialbook.be.user.pack.service;

import com.codegym.socialbook.be.user.pack.model.Review;

public interface IReviewService {
    void addNewReview(Review review,Long id);
    void deleteReview(Long id);
}
