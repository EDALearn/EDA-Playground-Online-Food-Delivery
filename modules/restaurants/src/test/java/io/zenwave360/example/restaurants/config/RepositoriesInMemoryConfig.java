package io.zenwave360.example.restaurants.config;

import io.zenwave360.example.restaurants.core.outbound.mongodb.*;
import io.zenwave360.example.restaurants.infrastructure.mongodb.inmemory.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

// @Configuration
public class RepositoriesInMemoryConfig {

    protected final RestaurantRepository restaurantRepository = new RestaurantRepositoryInMemory();

    @Bean
    @Primary
    public <T extends RestaurantRepository> T restaurantRepository() {
        return (T) restaurantRepository;
    }

    protected final MenuItemRepository menuItemRepository = new MenuItemRepositoryInMemory();

    @Bean
    @Primary
    public <T extends MenuItemRepository> T menuItemRepository() {
        return (T) menuItemRepository;
    }

    protected final KitchenOrderRepository kitchenOrderRepository = new KitchenOrderRepositoryInMemory();

    @Bean
    @Primary
    public <T extends KitchenOrderRepository> T kitchenOrderRepository() {
        return (T) kitchenOrderRepository;
    }

}
