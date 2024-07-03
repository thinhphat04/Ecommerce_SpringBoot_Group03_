package com.phat.e.project.Repository;

import com.phat.e.project.Entity.Review;
import com.phat.e.project.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {
}
