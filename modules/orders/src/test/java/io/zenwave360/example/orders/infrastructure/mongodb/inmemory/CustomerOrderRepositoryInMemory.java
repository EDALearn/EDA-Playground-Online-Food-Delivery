package io.zenwave360.example.orders.infrastructure.mongodb.inmemory;

import io.zenwave360.example.orders.core.domain.*;
import io.zenwave360.example.orders.core.outbound.mongodb.CustomerOrderRepository;

public class CustomerOrderRepositoryInMemory extends InMemoryMongodbRepository<CustomerOrder>
        implements CustomerOrderRepository {

}
