package io.zenwave360.example.delivery.infrastructure.mongodb.inmemory;

import io.zenwave360.example.delivery.core.domain.*;
import io.zenwave360.example.delivery.core.outbound.mongodb.DeliveryRepository;

import java.util.Optional;

public class DeliveryRepositoryInMemory extends InMemoryMongodbRepository<Delivery> implements DeliveryRepository {

    @Override
    public Optional<Delivery> findByOrderId(String orderId) {
        var results = findByField("orderId", orderId);
        if(!results.isEmpty()) {
            return Optional.of(results.get(0));
        }
        return Optional.empty();
    }
}
