package io.zenwave360.example.customers.core.implementation;

import io.zenwave360.example.customers.core.domain.*;
import io.zenwave360.example.customers.core.implementation.mappers.*;
import io.zenwave360.example.customers.core.inbound.*;
import io.zenwave360.example.customers.core.outbound.mongodb.*;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Service Implementation for managing [Customer]. */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

	private final CustomerRepository customerRepository;

	/** Constructor. */
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Transactional(readOnly = false)
	public Customer createCustomer(Customer input) {
		log.debug("Request to save Customer: {}", input);
		var customer = customerMapper.update(new Customer(), input);
		customer = customerRepository.save(customer);
		return customer;
	}

	@Transactional(readOnly = false)
	public Optional<Customer> updateCustomer(String id, Customer input) {
		log.debug("Request to update Customer : {}", input);
		var customer = customerRepository.findById(id).map(existingCustomer -> {
			return customerMapper.update(existingCustomer, input);
		}).map(customerRepository::save);
		return customer;
	}

	public Optional<Customer> updateCustomerAddress(String id, String identifier, Address input) {
		log.debug("Request updateCustomerAddress: {}", id);
		var customer = customerRepository.findById(id);
		if (customer.isPresent()) {
			var address = customerMapper.updateCustomerAddress(customer.get(), identifier, input);
			customerRepository.save(customer.get());
			// TODO send events
		}
		return customer;
	}

	@Transactional(readOnly = false)
	public void deleteCustomer(String id) {
		log.debug("Request to delete Customer : {}", id);
		customerRepository.deleteById(id);
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
