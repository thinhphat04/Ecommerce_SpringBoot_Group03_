package com.phat.e.project.Repository;

import com.phat.e.project.Entity.OrderDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderDetailRepository extends MongoRepository<OrderDetail, String> {
    List<OrderDetail> findByOrder_Id(String orderId);
    List<OrderDetail> findByProduct_Id(String productId);
}
