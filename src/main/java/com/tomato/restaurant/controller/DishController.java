package com.tomato.restaurant.controller;

import com.tomato.restaurant.entity.Dish;
import com.tomato.restaurant.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DishController {

    private final DishService dishService;

    @PostMapping("/api/restaurants/{restaurantId}/dishes")
    public void create(@RequestBody List<Dish> dishRequest, @PathVariable String restaurantId) {
       dishService.create(restaurantId, dishRequest);
    }

    @PutMapping("/api/restaurants/{restaurantId}/dishes/{dishId}")
    public void update(@RequestBody Dish dishRequest, @PathVariable String restaurantId, @PathVariable String dishId) {
       dishService.update(restaurantId, dishId, dishRequest);
    }

}
