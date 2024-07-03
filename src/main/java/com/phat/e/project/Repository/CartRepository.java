package com.phat.e.project.Repository;

import com.phat.e.project.Entity.Cart;
import com.phat.e.project.Entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.swing.text.html.Option;
import java.util.List;

public interface CartRepository extends MongoRepository<Cart, String> {
    List<Cart> findByUserId(String userId);

    List<Cart> findByProductId(String productId);

    Cart findByCustomer_IdAndProduct_Id(String userId, String productId);

}
