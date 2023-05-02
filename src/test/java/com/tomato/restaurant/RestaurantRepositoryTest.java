package com.tomato.restaurant;

import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Indexes;
import com.tomato.restaurant.entity.Restaurant;
import com.tomato.restaurant.repository.RestaurantRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static com.tomato.restaurant.TestData.restaurantList;
import static org.assertj.core.api.Assertions.assertThat;

//@Testcontainers
@DataMongoTest
public class RestaurantRepositoryTest {

    /*@Container //
    private static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.3");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }*/

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MongoOperations mongoOperations;

    @Test
    void saveRestaurant() {

        Assertions.assertThat(restaurantRepository.save(TestData.restaurant).getId()).isNotNull();
    }

    @Test
    void findAllRestaurants() {
        restaurantRepository.saveAll(restaurantList);
        assertThat(restaurantRepository.count()).isEqualTo(5) ;
    }

    @Test
    void findByLocationNear() {
        Point location = new Point(-73.991, 40.738);
        NearQuery query = NearQuery.near(location).maxDistance(new Distance(10, Metrics.MILES));
        GeoResults<Restaurant> results =  mongoOperations.geoNear(query, Restaurant.class);
        assertThat(results.getContent().stream().map(r->r.getContent()).toList().size()).isEqualTo(1);
    }

}
