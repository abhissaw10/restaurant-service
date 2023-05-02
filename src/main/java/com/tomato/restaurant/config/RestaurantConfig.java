package com.tomato.restaurant.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.Indexes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.OffsetDateTime;
import java.util.Optional;

@Configuration
public class RestaurantConfig {

   /* @Bean
    MongoClient mongoClient() {
        MongoClient client = MongoClients.create();
        CreateCollectionOptions c = new CreateCollectionOptions();
        client.getDatabase("test").createCollection("restaurant", c.);
        client.getDatabase("test").getCollection("restaurant").createIndex(Indexes.geo2dsphere("location"));
        return client;
    }

    @Bean
    MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoClient(), "test");
    }*/

    @Bean(name = "auditingDateTimeProvider")
    public DateTimeProvider dateTimeProvider() {
        return () -> Optional.of(OffsetDateTime.now());
    }
}
