package io.zenwave360.example.customers.config;

import io.zenwave360.example.customers.core.implementation.*;

public class InMemoryTestsManualContext extends InMemoryTestsConfig {

	public static final InMemoryTestsManualContext INSTANCE = new InMemoryTestsManualContext();

	public CustomerServiceImpl customerService() {
		return new CustomerServiceImpl(customerRepository());
	}

}
