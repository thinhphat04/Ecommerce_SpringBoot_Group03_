package com.phat.e.project.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "orderDetails")
public class OrderDetail extends BaseEntity{

    @DBRef
    private Order order;
    @DBRef
    private Product product;
    private int quantity;
    private float price;


}