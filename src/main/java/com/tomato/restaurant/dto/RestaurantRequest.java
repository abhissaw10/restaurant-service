package com.tomato.restaurant.dto;

import com.tomato.restaurant.entity.Address;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RestaurantRequest {
    String name;
    Address address;
    String phone;
    String image_url;
    List<String> tags;
    double latitude;
    double longitude;

    boolean isActive;


}
