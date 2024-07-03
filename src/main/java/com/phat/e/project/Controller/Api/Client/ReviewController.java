package com.phat.e.project.Controller.Api.Client;
import com.phat.e.project.Entity.Product;
import com.phat.e.project.Entity.Review;
import com.phat.e.project.Service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

     ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable String id) {
        return reviewService.getReviewById(id);
    }

    @PostMapping
    public String createReview(@Valid @RequestBody Review review) {
        try {
            Review created = reviewService.createReview(review);
            return "Review created successfully for User: " + created.getCustomer().getId() + " and Product: " + created.getProduct().getId();
        } catch (Exception e) {
            return "Error creating review: " + e.getMessage();
        }

    }

    @PutMapping("/{id}")
    public String updateReview(@PathVariable String id, @Valid @RequestBody Review review) {
        try {
            Review updated = reviewService.updateReview(id, review);
            return "Review update successfully for User: " + updated.getCustomer().getId() + " and Product: " + updated.getProduct().getId();
        } catch (Exception e) {
            return "Error creating review: " + e.getMessage();
        }

    }

    @DeleteMapping("/{id}")
    public boolean deleteReview(@PathVariable String id) {
        return reviewService.deleteReview(id);
    }
}
