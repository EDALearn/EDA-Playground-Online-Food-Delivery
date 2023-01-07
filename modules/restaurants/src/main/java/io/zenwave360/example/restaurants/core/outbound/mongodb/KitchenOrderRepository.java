package io.zenwave360.example.restaurants.core.outbound.mongodb;

import io.zenwave360.example.restaurants.core.domain.KitchenOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/** Spring Data MongoDB repository for the KitchenOrder entity. */
@SuppressWarnings("unused")
@Repository
public interface KitchenOrderRepository extends MongoRepository<KitchenOrder, String> {

    Optional<KitchenOrder> findByOrderId(String orderId);
}
