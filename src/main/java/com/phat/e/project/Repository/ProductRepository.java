package com.phat.e.project.Repository;

import com.phat.e.project.Entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByProductName(String productName);
}
