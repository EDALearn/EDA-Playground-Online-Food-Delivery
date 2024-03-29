package io.zenwave360.example.delivery.infrastructure.mongodb.inmemory;

import io.zenwave360.example.delivery.core.domain.*;
import io.zenwave360.example.delivery.core.outbound.mongodb.DeliveryRepository;

public class DeliveryRepositoryInMemory extends InMemoryMongodbRepository<Delivery> implements DeliveryRepository {

}
