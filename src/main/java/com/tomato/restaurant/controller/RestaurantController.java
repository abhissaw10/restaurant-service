package com.tomato.restaurant.controller;

import com.tomato.restaurant.dto.RestaurantRequest;
import com.tomato.restaurant.entity.Restaurant;
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
    @GetMapping("/api/restaurants/")
    public List<Restaurant> getAll() {
        return restaurantService.getAll();
    }

    @GetMapping("/api/restaurants/{id}")
    public Restaurant get(@PathVariable String id) {
        return restaurantService.get(id);
    }

    @GetMapping("/api/restaurants/byDistance")
    public List<Restaurant> getClosestTo(@RequestParam("lat") Double latitude,
                                         @RequestParam("long") Double longitude,
                                         @RequestParam("d") int distance) {
        return restaurantService.getNearBy(latitude, longitude, distance);
    }
}
