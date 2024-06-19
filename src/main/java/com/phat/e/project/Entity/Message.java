package com.phat.e.project.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "messages")
public class Message {
    @Id
    private String id;
    @DBRef
    private User sender;
    @DBRef
    private User recipient;
    private String content;
    private Date timestamp;
    private boolean isRead;

}