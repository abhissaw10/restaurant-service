package com.tomato.restaurant.repository;

import com.tomato.restaurant.entity.Restaurant;

import org.springframework.data.repository.CrudRepository;


public interface RestaurantRepository extends CrudRepository<Restaurant, String> {

}
