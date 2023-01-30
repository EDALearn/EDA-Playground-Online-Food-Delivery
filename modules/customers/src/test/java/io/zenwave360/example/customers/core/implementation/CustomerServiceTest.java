package io.zenwave360.example.customers.core.implementation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import io.zenwave360.example.customers.config.*;
import io.zenwave360.example.customers.core.domain.*;
import io.zenwave360.example.customers.core.implementation.mappers.*;
import io.zenwave360.example.customers.core.inbound.*;
import io.zenwave360.example.customers.core.inbound.dtos.*;
import io.zenwave360.example.customers.core.outbound.mongodb.*;
import io.zenwave360.example.customers.infrastructure.mongodb.inmemory.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Acceptance Test for CustomerService. */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerServiceTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    ServicesInMemoryConfig context = new ServicesInMemoryConfig();

    CustomerServiceImpl customerService = context.customerService();

    CustomerRepositoryInMemory customerRepository = context.customerRepository();

    @BeforeEach
    void setUp() {
        customerRepository.save(new Customer());
    }

    @Test
    @Order(0)
    void testCRUDCustomer() {
        /*
         * var input = new Customer(); // TODO fill input data var customer =
         * customerService.createCustomer(input); assertNotNull(customer.getId());
         * assertTrue(customerRepository.containsEntity(customer));
         * 
         * var id = customer.getId(); var customerUpdate = new Customer(); // TODO fill
         * update data assertTrue(customerRepository.containsKey(id)); var customerUpdated
         * = customerService.updateCustomer(id, customerUpdate);
         * assertTrue(customerUpdated.isPresent());
         * assertTrue(customerRepository.containsEntity(customerUpdated.get()));
         * 
         * assertTrue(customerRepository.containsKey(id));
         * customerService.deleteCustomer(id);
         * assertFalse(customerRepository.containsKey(id));
         */
    }

    @Test
    @Order(0)
    void createCustomerTest() {
        var input = new Customer();
        // TODO fill input data
        // input.setFirstName("aa");
        // input.setLastName("aa");
        // input.setEmail("");
        // input.setPhone("");
        // input.setAddresses(new Address());
        var customer = customerService.createCustomer(input);
        assertNotNull(customer.getId());
        assertTrue(customerRepository.containsEntity(customer));
    }

    @Test
    @Order(1)
    void updateCustomerTest() {
        var id = "1"; // TODO fill id
        var input = new Customer();
        // TODO fill input data
        // input.setFirstName("aa");
        // input.setLastName("aa");
        // input.setEmail("");
        // input.setPhone("");
        // input.setAddresses(new Address());
        assertTrue(customerRepository.containsKey(id));
        var customer = customerService.updateCustomer(id, input);
        assertTrue(customer.isPresent());
        assertTrue(customerRepository.containsEntity(customer.get()));
    }

    @Test
    @Order(2)
    void updateCustomerAddressTest() { // TODO: implement this test
    }

    @Test
    @Order(3)
    void deleteCustomerTest() {
        var id = "1"; // TODO fill id
        assertTrue(customerRepository.containsKey(id));
        customerService.deleteCustomer(id);
        assertFalse(customerRepository.containsKey(id));
    }

    @Test
    @Order(4)
    void getCustomerTest() {
        var id = "1"; // TODO fill id
        var customer = customerService.getCustomer(id);
        assertTrue(customer.isPresent());
    }

    @Test
    @Order(5)
    void listCustomersTest() {
        // var results = customerService.listCustomers(PageRequest.of(0, 10));
        // assertNotNull(results);
    }

}
