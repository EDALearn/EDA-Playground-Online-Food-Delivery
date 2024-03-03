package io.zenwave360.example.customers.core.implementation;

import io.zenwave360.example.customers.core.domain.*;
import io.zenwave360.example.customers.core.implementation.mappers.*;
import io.zenwave360.example.customers.core.inbound.*;
import io.zenwave360.example.customers.core.inbound.dtos.*;
import io.zenwave360.example.customers.core.outbound.events.*;
import io.zenwave360.example.customers.core.outbound.mongodb.*;
import java.math.*;
import java.time.*;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Service Implementation for managing [Customer]. */
@Service
@Transactional(readOnly = true)
@lombok.AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final CustomerServiceMapper customerServiceMapper = CustomerServiceMapper.INSTANCE;

    private final CustomerRepository customerRepository;

    private final EventsMapper eventsMapper = EventsMapper.INSTANCE;

    private final ICustomerEventsProducer eventsProducer;

    @Transactional
    public Customer createCustomer(Customer input) {
        log.debug("Request to save Customer: {}", input);
        var customer = customerServiceMapper.update(new Customer(), input);
        customer = customerRepository.save(customer);
        // emit events
        var customerEvent = eventsMapper.asCustomerEvent(customer);
        eventsProducer.onCustomerEvent(customerEvent);
        return customer;
    }

    @Transactional
    public Optional<Customer> updateCustomer(String id, Customer input) {
        log.debug("Request to update Customer : {}", input);
        var customer = customerRepository.findById(id).map(existingCustomer -> {
            return customerServiceMapper.update(existingCustomer, input);
        }).map(customerRepository::save);
        if (customer.isPresent()) {
            // emit events
            var customerEvent = eventsMapper.asCustomerEvent(customer.get());
            eventsProducer.onCustomerEvent(customerEvent);
        }
        return customer;
    }

    public Optional<Customer> updateCustomerAddress(String id, String identifier, Address address) {
        log.debug("Request updateCustomerAddress: {}", id);
        var customer = customerRepository.findById(id).map(existingCustomer -> {
            return customerServiceMapper.update(existingCustomer, identifier, address);
        }).map(customerRepository::save);
        if (customer.isPresent()) {
            // emit events
            var customerEvent = eventsMapper.asCustomerEvent(customer.get());
            eventsProducer.onCustomerEvent(customerEvent);
            var customerAddressUpdated = eventsMapper.asCustomerAddressUpdated(customer.get());
            eventsProducer.onCustomerAddressUpdated(customerAddressUpdated);
        }
        return customer;
    }

    @Transactional
    public void deleteCustomer(String id) {
        log.debug("Request to delete Customer : {}", id);
        customerRepository.deleteById(id);
        // emit events
        var customerEvent = eventsMapper.asCustomerEvent(id);
        eventsProducer.onCustomerEvent(customerEvent);
    }

    public Optional<Customer> getCustomer(String id) {
        log.debug("Request to get Customer : {}", id);
        var customer = customerRepository.findById(id);
        return customer;
    }

    public Page<Customer> listCustomers(Pageable pageable) {
        log.debug("Request list of Customers: {}", pageable);
        var page = customerRepository.findAll(pageable);
        return page;
    }

}
