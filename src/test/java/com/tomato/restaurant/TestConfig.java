package com.tomato.restaurant;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.model.Indexes;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@TestConfiguration
public class TestConfig {
    @Bean
    MongoClient mongoClient() {
        MongoClient client = MongoClients.create();

        client.getDatabase("test").createCollection("restaurant");
        client.getDatabase("test").getCollection("restaurant").createIndex(Indexes.geo2dsphere("location"));
        return client;
    }

    @Bean
    MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoClient(), "test");
    }
}
