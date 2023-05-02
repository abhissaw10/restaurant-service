package com.tomato.restaurant.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Builder
@Data
@Document
public class Dish extends AuditMetadata{

    @Id
    String id;
    String name;
    String description;
    Double price;
    Double rating;
    String image_url;
    List<String> tags;

    boolean isAvailable;


}
