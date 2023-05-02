package com.tomato.restaurant.service;

import com.tomato.restaurant.dto.RestaurantRequest;
import com.tomato.restaurant.entity.Restaurant;
import com.tomato.restaurant.exception.RestaurantNotFoundException;
import com.tomato.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final MongoOperations mongoOperations;

    public String create(RestaurantRequest restaurantRequest) {
        Restaurant restaurant =
                Restaurant.
                builder()
                .id(UUID.randomUUID().toString())
                .name(restaurantRequest.getName())
                .phone(restaurantRequest.getPhone())
                .image_url(restaurantRequest.getImage_url())
                .address(restaurantRequest.getAddress())
                .tags(restaurantRequest.getTags())
                .location(new GeoJsonPoint(restaurantRequest.getLatitude(), restaurantRequest.getLongitude()))

                .build();
        //image upload goes here. Set the ImageId to the restaurantRequest
        Restaurant restaurantEntity = restaurantRepository.save(restaurant);
        return restaurantEntity.getId();
    }

    public List<Restaurant> getAll() {
        List<Restaurant> restaurants = new ArrayList();
        restaurantRepository.findAll().forEach(r->restaurants.add(r) );
        return restaurants;
    }

    public Restaurant get(String id) {
        return restaurantRepository.findById(id).orElseThrow(RestaurantNotFoundException::new);
    }

    public List<Restaurant> getNearBy(double x, double y, int distance) {
        Point location = new Point(x, y);
        NearQuery query = NearQuery.near(location).maxDistance(new Distance(distance, Metrics.MILES));
        GeoResults<Restaurant> results =  mongoOperations.geoNear(query, Restaurant.class);
        return results.getContent().stream().map(r->r.getContent()).toList();
    }
}
