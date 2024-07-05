package com.phat.e.project.Repository;

import com.phat.e.project.Entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface CartRepository extends MongoRepository<Cart, String> {
    List<Cart> findByCustomerId(String cusID);

    List<Cart> findByProductId(String productId);

    Cart findByCustomer_IdAndProduct_Id(String userId, String productId);

}
