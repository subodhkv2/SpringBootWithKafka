package com.infusion.kafka.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Book")
public class Book {
    @Id
    private String id;
    private String title;
    private String author;

}
