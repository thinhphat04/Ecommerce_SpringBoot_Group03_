package com.phat.e.project.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product extends BaseEntity {

    private String productName;
    private String description;
    private int price;
    private int quantity;
    private String PublicId;
    @DBRef
    private Category category;
    private LocalDateTime dateAdded;
    private boolean status;


}