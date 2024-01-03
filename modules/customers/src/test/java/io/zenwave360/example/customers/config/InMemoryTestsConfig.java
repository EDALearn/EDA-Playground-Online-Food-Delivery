package io.zenwave360.example.customers.config;

import io.zenwave360.example.customers.core.outbound.mongodb.*;
import io.zenwave360.example.customers.infrastructure.mongodb.inmemory.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

// @Configuration
public class InMemoryTestsConfig {

	private final CustomerRepository customerRepository = new CustomerRepositoryInMemory();

	@Bean
	@Primary
	public <T extends CustomerRepository> T customerRepository() {
		return (T) customerRepository;
	}

}
