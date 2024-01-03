package io.zenwave360.example.customers.core.inbound;

import io.zenwave360.example.customers.core.domain.*;
import io.zenwave360.example.customers.core.inbound.dtos.*;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/** Inbound Service Port for managing [Customer]. */
public interface CustomerService {

    /**
     * Creates a customer.
     * @param customer the entity to save.
     * @return the persisted entity.
     */
    public Customer createCustomer(Customer input);

    /**
     * Updates a customer.
     * @param customer the entity to update.
     * @return the persisted entity.
     */
    public Optional<Customer> updateCustomer(String id, Customer input);

    /** Updates a the customer address identified by address.identifier */
    public Optional<Customer> updateCustomerAddress(String id, String identifier, Address address);

    /**
     * Delete the "id" customer.
     * @param id the id of the entity.
     */
    public void deleteCustomer(String id);

    /**
     * Get the "id" customer.
     * @param id the id of the entity.
     * @return the entity.
     */
    public Optional<Customer> getCustomer(String id);

    /**
     * Get all the Customers.
     * @param criteria the criteria with pagination information.
     * @return the list of entities.
     */
    public Page<Customer> listCustomers(Pageable pageable);

}
