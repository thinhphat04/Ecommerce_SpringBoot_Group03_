package com.phat.e.project.Repository;

import com.phat.e.project.Entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findByCustomer_Id(String customerId);
}
