package io.zenwave360.example.restaurants.infrastructure.mongodb.inmemory;

import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.outbound.mongodb.KitchenOrderRepository;

import java.util.Optional;

public class KitchenOrderRepositoryInMemory extends InMemoryMongodbRepository<KitchenOrder>
        implements KitchenOrderRepository {

    @Override
    public Optional<KitchenOrder> findByOrderId(String orderId) {
        var results = findByField("orderId", orderId);
        if(!results.isEmpty()) {
            return Optional.of(results.get(0));
        }
        return Optional.empty();
    }
}
