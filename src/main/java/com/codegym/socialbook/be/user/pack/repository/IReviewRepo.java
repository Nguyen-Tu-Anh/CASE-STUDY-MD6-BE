package com.codegym.socialbook.be.user.pack.repository;

import com.codegym.socialbook.be.user.pack.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReviewRepo extends JpaRepository<Review, Long> {
}
