package com.phat.e.project.Service;

import com.phat.e.project.Entity.Review;

import java.util.List;

public interface IReviewService {
    List<Review> getAllReviews();

    Review getReviewById(String id);

    Review createReview(Review review);

    Review updateReview(String id, Review updatedReview);

    boolean deleteReview(String id);
}
