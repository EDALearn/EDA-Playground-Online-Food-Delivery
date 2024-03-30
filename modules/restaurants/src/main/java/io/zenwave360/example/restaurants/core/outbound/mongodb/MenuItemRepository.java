package io.zenwave360.example.restaurants.core.outbound.mongodb;

import io.zenwave360.example.restaurants.core.domain.MenuItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/** Spring Data MongoDB repository for the MenuItem entity. */
@SuppressWarnings("unused")
@Repository
public interface MenuItemRepository extends MongoRepository<MenuItem, String> {

}
