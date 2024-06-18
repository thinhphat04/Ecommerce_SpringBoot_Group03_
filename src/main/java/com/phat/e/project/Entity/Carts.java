package com.phat.e.project.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "carts")
public class Carts {
    @Id
    private String id;
    @DBRef
    private User customerId;
    private List<ProductQuantity> products;
    private Date createdAt;
    private Date updatedAt;

    // getters and setters
}

class ProductQuantity {
    @DBRef
    private Product productId;
    private int quantity;

    // getters and setters
}