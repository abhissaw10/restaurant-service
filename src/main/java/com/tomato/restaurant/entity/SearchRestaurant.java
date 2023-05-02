package com.tomato.restaurant.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class SearchRestaurant {
    @Id
    String id;
    String name;
    double distance;
    List<String> tags;
}
