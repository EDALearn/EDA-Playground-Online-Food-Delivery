package io.zenwave360.example.orders.core.outbound.mongodb;

import io.zenwave360.example.orders.core.domain.CustomerOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/** Spring Data MongoDB repository for the CustomerOrder entity. */
@SuppressWarnings("unused")
@Repository
public interface CustomerOrderRepository extends MongoRepository<CustomerOrder, String> {

}
