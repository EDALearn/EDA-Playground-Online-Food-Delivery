package io.zenwave360.example.orders.config;

import io.zenwave360.example.orders.customers.client.CustomerApi;
import io.zenwave360.example.orders.restaurants.client.RestaurantBackOfficeApi;
import io.zenwave360.example.orders.restaurants.client.RestaurantOrdersApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpInterfacesWebClientConfig {

    @Bean
    WebClient webClient() {
        return WebClient.builder()
            .baseUrl("http://localhost:8080/api")
            .filter(ExchangeFilterFunctions.basicAuthentication("user", "password"))
            .build();

    }

    @Bean
    CustomerApi customerHttpProxy(WebClient webClient) {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
            .build();
        return factory.createClient(CustomerApi.class);
    }

    @Bean
    RestaurantBackOfficeApi restaurantBackOfficeHttpProxy(WebClient webClient) {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
            .build();
        return factory.createClient(RestaurantBackOfficeApi.class);
    }

    @Bean
    RestaurantOrdersApi restaurantOrdersHttpProxy(WebClient webClient) {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
            .build();
        return factory.createClient(RestaurantOrdersApi.class);
    }

}
