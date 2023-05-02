package com.tomato.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mongodb.lang.Nullable;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@Data
@Document(collection = "restaurant")
public class Restaurant extends  AuditMetadata{
    @Id
    String id;
    String name;
    Address address;
    String phone;
    String image_url;
    List<Dish> dishes;

    List<String> tags;

    boolean isActive;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    GeoJsonPoint location;

}



