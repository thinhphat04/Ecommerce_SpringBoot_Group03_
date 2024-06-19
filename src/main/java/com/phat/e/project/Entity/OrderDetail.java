package com.phat.e.project.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "orderDetails")
public class OrderDetail {
    @Id
    private String id;
    @DBRef
    private Order order;
    @DBRef
    private Product product;
    private int quantity;
    private float price;
    private Date createdAt;
    private Date updatedAt;

    // getters and setters
}