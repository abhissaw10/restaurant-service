package com.tomato.restaurant;

import com.tomato.restaurant.entity.Address;
import com.tomato.restaurant.entity.Restaurant;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.util.List;

public class TestData {

    static Restaurant restaurant = Restaurant.builder()
            .name("Cloud Kitchen")
            .location(new GeoJsonPoint(-73.991, 40.738))
                .address(Address
                        .builder()
                        .addressLine1("Pyda Palms")
                        .city("bangalore")
                        .state("ka")
                        .postal_code("560067")
                        .area("kadugodi")

            .build())
            .build();

    static List<Restaurant> restaurantList = List.of(Restaurant
            .builder()
            .name("Cloud Kitchen 1")
            .location(new GeoJsonPoint(13.005, 77.752))
            .address(Address
                            .builder()
                            .addressLine1("Whitefield Foods Ltd")
                            .city("bangalore")
                            .state("ka")
                            .postal_code("560067")
                            .area("Whitefield")

                            .build())
            .build(),
            Restaurant
                    .builder()
                    .name("Lakshmi Bar and Restaurant")
                    .location(new GeoJsonPoint(13.030, 77.604))
                    .address(Address
                            .builder()
                            .addressLine1("R T Nagar")
                            .city("bangalore")
                            .state("ka")
                            .postal_code("560067")
                            .area("R T Nagar")
                            .build())
                    .build(),
            Restaurant
                    .builder()
                    .name("HSR Bar and Restaurant")
                    .location(new GeoJsonPoint(18.147, 41.538))
                    .address(Address
                            .builder()
                            .addressLine1("HSR Layout")
                            .city("bangalore")
                            .state("ka")
                            .postal_code("560067")
                            .area("HSR Layout")
                            .build())
                    .build()
            ,Restaurant
                    .builder()
                    .name("Whitefield Delicacies")
                    .location(new GeoJsonPoint(44.373, -71.611))
                    .address(Address
                            .builder()
                            .addressLine1("Whitefield")
                            .city("bangalore")
                            .state("ka")
                            .postal_code("560067")
                            .area("Whitefield")
                            .build())
                    .build()
            );
}
