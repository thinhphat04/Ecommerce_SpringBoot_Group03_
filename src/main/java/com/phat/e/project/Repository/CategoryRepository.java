package com.phat.e.project.Repository;

import com.phat.e.project.Entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
