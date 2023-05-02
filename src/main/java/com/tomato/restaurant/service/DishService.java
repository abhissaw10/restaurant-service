package com.tomato.restaurant.service;

import com.tomato.restaurant.entity.Dish;
import com.tomato.restaurant.entity.Restaurant;
import com.tomato.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DishService {

    private final RestaurantRepository restaurantRepository;

    public void create(String restaurantId, List<Dish> dishes) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        if(restaurant.getDishes() == null) {
            restaurant.setDishes(dishes);
        }else {
            restaurant.getDishes().addAll(dishes);
            // TODO dish image upload goes here
        }
        restaurantRepository.save(restaurant);
    }

    public void update(String restaurantId, String dishId, Dish dishRequest) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        List<Dish> dishes = restaurant.getDishes();
        if(dishes!=null){
            for(Dish dish: dishes){
                if(dish.getId().equals(dishId)){
                    dish.setName(dishRequest.getName());
                    dish.setDescription(dishRequest.getDescription());
                    dish.setPrice(dishRequest.getPrice());
                    dish.setRating(dishRequest.getRating());
                    dish.setImage_url(dishRequest.getImage_url());
                    dish.setTags(dishRequest.getTags());
                    break;
                }
            }
            restaurant.setDishes(dishes);
            restaurantRepository.save(restaurant);
        }//Should there be an else condition here?
    }
}
