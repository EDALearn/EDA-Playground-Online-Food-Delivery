package io.zenwave360.example.customers.adapters.web;

import io.zenwave360.example.customers.adapters.web.model.*;
import io.zenwave360.example.customers.config.ServicesInMemoryConfig;
import java.math.*;
import java.time.*;
import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Test controller for CustomerApiController. */
public class CustomerApiControllerTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    ServicesInMemoryConfig context = new ServicesInMemoryConfig();

    CustomerApiController controller = new CustomerApiController().setCustomerService(context.customerService());

    @BeforeEach
    void setUp() {
        context.reloadTestData();
    }

    @Test
    public void createCustomerTest() {
        CustomerDTO reqBody = null;
        var response = controller.createCustomer(reqBody);
        Assertions.assertEquals(201, response.getStatusCode().value());
    }

    @Test
    public void listCustomersTest() {
        Optional<String> search = null;
        Optional<Integer> page = null;
        Optional<Integer> limit = null;
        Optional<List<String>> sort = null;
        var response = controller.listCustomers(search, page, limit, sort);
        Assertions.assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void updateCustomerTest() {
        String customerId = null;
        CustomerDTO reqBody = null;
        var response = controller.updateCustomer(customerId, reqBody);
        Assertions.assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void deleteCustomerTest() {
        String customerId = null;
        var response = controller.deleteCustomer(customerId);
        Assertions.assertEquals(204, response.getStatusCode().value());
    }

    @Test
    public void getCustomerTest() {
        String customerId = null;
        var response = controller.getCustomer(customerId);
        Assertions.assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void updateCustomerAddressTest() {
        String customerId = null;
        String identifier = null;
        AddressDTO reqBody = null;
        var response = controller.updateCustomerAddress(customerId, identifier, reqBody);
        Assertions.assertEquals(200, response.getStatusCode().value());
    }

}
