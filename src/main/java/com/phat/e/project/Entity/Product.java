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
@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String productName;
    private String description;
    private int price;
    private int quantity;
    @DBRef
    private Category category;
    @DBRef
    private User seller;
    private Date dateAdded;
    private boolean status;
    private Date createdAt;
    private Date updatedAt;

}