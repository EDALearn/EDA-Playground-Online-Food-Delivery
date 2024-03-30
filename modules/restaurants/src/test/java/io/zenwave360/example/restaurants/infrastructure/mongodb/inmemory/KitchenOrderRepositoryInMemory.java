package io.zenwave360.example.restaurants.infrastructure.mongodb.inmemory;

import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.outbound.mongodb.KitchenOrderRepository;

public class KitchenOrderRepositoryInMemory extends InMemoryMongodbRepository<KitchenOrder>
        implements KitchenOrderRepository {

}
