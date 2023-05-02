package com.tomato.restaurant.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

@Builder
public record Address (
                String addressLine1,
                String city,
                String state,
                String area,
                String postal_code,
                String country){
}
