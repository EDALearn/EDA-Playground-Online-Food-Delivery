package io.zenwave360.example.customers.core.outbound.mongodb;

import io.zenwave360.example.customers.core.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/** Spring Data MongoDB repository for the Customer entity. */
@SuppressWarnings("unused")
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

}
