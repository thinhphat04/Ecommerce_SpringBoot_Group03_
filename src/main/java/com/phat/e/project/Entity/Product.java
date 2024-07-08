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
@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private double rating;
    private List<String> colours;
    private String image;
    private List<String> images;
    @DBRef
    private List<Review> reviews;
    private int numberOfReviews;
    private List<String> sizes;
    @DBRef
    private Category category;
    private String genderAgeCategory;
    private int countInStock;
    private Date dateAdded;
}