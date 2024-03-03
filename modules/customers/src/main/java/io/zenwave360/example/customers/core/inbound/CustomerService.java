package io.zenwave360.example.customers.core.inbound;

import io.zenwave360.example.customers.core.domain.*;
import io.zenwave360.example.customers.core.inbound.dtos.*;
import java.math.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/** Inbound Service Port for managing [Customer]. */
public interface CustomerService {

    /**
     * Create customer javadoc comment
     *
     * <p>
     * With Events: [CustomerEvent].
     */
    public Customer createCustomer(Customer input);

    /** With Events: [CustomerEvent]. */
    public Optional<Customer> updateCustomer(String id, Customer input);

    /**
     * Updates a the customer address identified by address.identifier
     *
     * <p>
     * With Events: [CustomerEvent, CustomerAddressUpdated].
     */
    public Optional<Customer> updateCustomerAddress(String id, String identifier, Address address);

    /** With Events: [CustomerEvent]. */
    public void deleteCustomer(String id);

    /** */
    public Optional<Customer> getCustomer(String id);

    /** */
    public Page<Customer> listCustomers(Pageable pageable);

}
