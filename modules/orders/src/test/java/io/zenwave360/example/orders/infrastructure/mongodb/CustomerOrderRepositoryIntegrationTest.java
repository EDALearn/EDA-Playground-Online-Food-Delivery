package io.zenwave360.example.orders.infrastructure.mongodb;

import io.zenwave360.example.orders.core.domain.*;
import io.zenwave360.example.orders.core.outbound.mongodb.CustomerOrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerOrderRepositoryIntegrationTest extends BaseRepositoryIntegrationTest {

    @Autowired
    CustomerOrderRepository customerOrderRepository;

    @Test
    public void findAllTest() {
        var results = customerOrderRepository.findAll();
        Assertions.assertFalse(results.isEmpty());
    }

    @Test
    public void findByIdTest() {
        var id = "1";
        var customerOrder = customerOrderRepository.findById(id).orElseThrow();
        Assertions.assertTrue(customerOrder.getId() != null);
        Assertions.assertTrue(customerOrder.getVersion() != null);
    }

    @Test
    public void saveTest() {
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setOrderTime(null);
        customerOrder.setStatus(null);
        customerOrder.setCustomerDetails(null);
        customerOrder.setRestaurantDetails(null);
        customerOrder.setOrderItems(null);

        var created = customerOrderRepository.save(customerOrder);
        Assertions.assertTrue(created.getId() != null);
        Assertions.assertTrue(created.getVersion() != null);
    }

    @Test
    public void updateTest() {
        var id = "1";
        var customerOrder = customerOrderRepository.findById(id).orElseThrow();
        customerOrder.setOrderTime(null);
        customerOrder.setStatus(null);
        customerOrder.setCustomerDetails(null);
        customerOrder.setRestaurantDetails(null);
        customerOrder.setOrderItems(null);

        customerOrder = customerOrderRepository.save(customerOrder);
        Assertions.assertEquals("", customerOrder.getOrderTime());
        Assertions.assertEquals("", customerOrder.getStatus());
        Assertions.assertEquals("", customerOrder.getCustomerDetails());
        Assertions.assertEquals("", customerOrder.getRestaurantDetails());
        Assertions.assertEquals("", customerOrder.getOrderItems());
    }

    @Test
    public void deleteTest() {
        var id = "1";
        customerOrderRepository.deleteById(id);
        var notFound = customerOrderRepository.findById(id);
        Assertions.assertFalse(notFound.isPresent());
    }

}
