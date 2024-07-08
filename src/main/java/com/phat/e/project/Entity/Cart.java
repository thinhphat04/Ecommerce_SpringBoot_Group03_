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
@Document(collection = "carts")
public class Cart {
    @Id
    private String id;
    @DBRef
    private Product product;
    private int quantity;
    private String selectedSize;
    private String selectedColour;
    private String productName;
    private String productImage;
    private double productPrice;
    private Date reservationExpiry;
    private boolean reserved;
}