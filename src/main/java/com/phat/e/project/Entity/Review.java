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
@Document(collection = "reviews")
public class Review extends BaseEntity{

    @DBRef
    private Product product;
    @DBRef
    private User customer;
    private int rating;
    private String comment;
    private LocalDateTime reviewDate;


}