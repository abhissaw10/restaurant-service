package com.tomato.restaurant.controller;

import com.tomato.restaurant.dto.RestaurantRequest;
import com.tomato.restaurant.entity.Restaurant;
import com.tomato.restaurant.entity.SearchRestaurant;
import com.tomato.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping("/api/restaurants")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody RestaurantRequest restaurantRequest) {
        return restaurantService.create(restaurantRequest);
    }

    @PutMapping("/api/restaurants/{restaurantId}")
    public void update(@RequestBody RestaurantRequest restaurantRequest, @PathVariable String restaurantId) {
        restaurantService.update(restaurantRequest, restaurantId);
    }
    @GetMapping("/api/restaurants/")
    public List<Restaurant> getAll() {
        return restaurantService.getAll();
    }

    @GetMapping("/api/restaurants/{id}")
    public Restaurant get(@PathVariable String id) {
        return restaurantService.get(id);
    }

    @GetMapping("/api/restaurants/byDistance")
    public List<SearchRestaurant> getClosestTo(@RequestParam("lat") Double latitude,
                                               @RequestParam("long") Double longitude,
                                               @RequestParam("dist") int distance) {
        return restaurantService.getNearBy(latitude, longitude, distance);
    }
}
