package io.zenwave360.example.customers.infrastructure.mongodb.inmemory;

import io.zenwave360.example.customers.core.domain.*;
import io.zenwave360.example.customers.core.outbound.mongodb.CustomerRepository;

public class CustomerRepositoryInMemory extends InMemoryMongodbRepository<Customer> implements CustomerRepository {

}
