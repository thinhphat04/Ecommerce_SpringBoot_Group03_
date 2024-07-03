package com.phat.e.project.Service;

import com.phat.e.project.Entity.Product;
import com.phat.e.project.Entity.Review;
import com.phat.e.project.Entity.User;
import com.phat.e.project.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements IReviewService {
    LocalDateTime now = LocalDateTime.now();
    ReviewRepository reviewRepository;
    ProductService productService;
   UserService userService;
    @Autowired
    public ReviewService(ReviewRepository reviewRepository, ProductService productService, UserService userService) {
        this.reviewRepository = reviewRepository;
        this.productService = productService;
        this.userService = userService;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReviewById(String id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public Review createReview(Review review) {
        validateProductAndUser(review);
        review.setReviewDate(now);
        review.setCreatedAt(now);
        review.setUpdatedAt(now);
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(String id, Review updatedReview) {
        validateProductAndUser(updatedReview);
        Optional<Review> existingReview = reviewRepository.findById(id);
        if (existingReview.isPresent()) {
            Review review = existingReview.get();
            review.setProduct(updatedReview.getProduct());
            review.setCustomer(updatedReview.getCustomer());
            review.setRating(updatedReview.getRating());
            review.setComment(updatedReview.getComment());
            review.setUpdatedAt(now);

            return reviewRepository.save(review);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteReview(String id) {
        Optional<Review> existingReview = reviewRepository.findById(id);
        if (existingReview.isPresent()) {
            reviewRepository.delete(existingReview.get());
            return true;
        } else {
            return false;
        }
    }
    private void validateProductAndUser(Review review) {
        // Check if product exists
        Product product = productService.getOneProduct(review.getProduct().getId());
        if (product == null) {
            throw new IllegalArgumentException("Product does not exist.");
        }

        // Check if user exists
        User customer = userService.getOneUser(review.getCustomer().getId());
        if (customer == null) {
            throw new IllegalArgumentException("Customer does not exist.");
        }
    }
}
