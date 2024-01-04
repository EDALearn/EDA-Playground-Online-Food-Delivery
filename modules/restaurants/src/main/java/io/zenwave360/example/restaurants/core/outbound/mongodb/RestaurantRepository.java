package io.zenwave360.example.restaurants.core.outbound.mongodb;

import io.zenwave360.example.restaurants.core.domain.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/** Spring Data MongoDB repository for the Restaurant entity. */
@SuppressWarnings("unused")
@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String> {

}
