package io.zenwave360.example.orders.core.implementation;

import io.zenwave360.example.orders.core.domain.*;
import io.zenwave360.example.orders.core.implementation.mappers.*;
import io.zenwave360.example.orders.core.inbound.*;
import io.zenwave360.example.orders.core.inbound.dtos.*;
import io.zenwave360.example.orders.core.outbound.events.*;
import io.zenwave360.example.orders.core.outbound.mongodb.*;

import java.time.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import io.zenwave360.example.orders.customers.client.CustomerApi;
import io.zenwave360.example.orders.restaurants.client.RestaurantBackOfficeApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Service Implementation for managing [CustomerOrder]. */
@Service
@Transactional(readOnly = true)
@lombok.AllArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final OrdersServiceMapper ordersServiceMapper = OrdersServiceMapper.INSTANCE;

    private final CustomerOrderRepository customerOrderRepository;

    private final EventsMapper eventsMapper = EventsMapper.INSTANCE;

    private final IOrdersEventsProducer eventsProducer;

    private final RestaurantBackOfficeApi restaurantBackOfficeApi;
    private final CustomerApi customerApi;

    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public Optional<CustomerOrder> getCustomerOrder(String id) {
        log.debug("[CRUD] Request to get CustomerOrder : {}", id);
        var customerOrder = customerOrderRepository.findById(id);
        return customerOrder;
    }

    @Transactional
    public CustomerOrder createOrder(CustomerOrderInput input) {
        log.debug("Request createOrder: {}", input);

        var restaurant = restaurantBackOfficeApi.getRestaurant(input.getRestaurantId()).getBody();
        var customer = customerApi.getCustomer(input.getCustomerId()).getBody();
        var address = customer.getAddresses().stream().filter(a -> Objects.equals(a.getIdentifier(), input.getAddressIdentifier())).findFirst().orElseThrow();
        var customerOrder = ordersServiceMapper.update(new CustomerOrder(), input, customer, address, restaurant);
        customerOrder.setStatus(OrderStatus.RECEIVED);
        customerOrder.setOrderTime(Instant.now());

        // save
        customerOrder = customerOrderRepository.save(customerOrder);

        // emit events
        var orderEvent = eventsMapper.asOrderEvent(customerOrder);
        eventsProducer.onOrderEvent(orderEvent);
        return customerOrder;
    }

    @Transactional
    public CustomerOrder updateOrder(String id, CustomerOrderInput input) {
        log.debug("Request updateOrder: {} {}", id, input);
        AtomicReference<OrderStatus> previousStatus = new AtomicReference<>();
        var customerOrder = customerOrderRepository.findById(id).map(existingCustomerOrder -> {
            previousStatus.set(existingCustomerOrder.getStatus());
            return ordersServiceMapper.update(existingCustomerOrder, input);
        }).map(customerOrderRepository::save).orElseThrow();
        // emit events
        var orderEvent = eventsMapper.asOrderEvent(customerOrder);
        eventsProducer.onOrderEvent(orderEvent);
        if (Objects.equals(previousStatus.get(), customerOrder.getStatus())) {
            var orderStatusUpdated = eventsMapper.asOrderStatusUpdated(customerOrder, previousStatus.get());
            eventsProducer.onOrderStatusUpdated(orderStatusUpdated);
        }
        return customerOrder;
    }

    @Transactional
    public CustomerOrder updateKitchenStatus(String id, KitchenStatusInput input) {
        log.debug("Request updateKitchenStatus: {} {}", id, input);
        var customerOrder = customerOrderRepository.findById(id).orElseThrow();
        var previousStatus = customerOrder.getStatus();

        if(KitchenStatus.REJECTED.equals(input.getKitchenStatus()) || KitchenStatus.CANCELLED.equals(input.getKitchenStatus())) {
            return cancelOrder(id, new CancelOrderInput().setId(id).setReason("Kitchen rejected order"));
        }

        customerOrder.setStatus(eventsMapper.asOrderStatus(input.getKitchenStatus(), previousStatus));
        customerOrder = customerOrderRepository.save(customerOrder);

        // emit events
        var orderStatusEvent = eventsMapper.asOrderStatusUpdated(customerOrder, previousStatus);
        eventsProducer.onOrderStatusUpdated(orderStatusEvent);

        return customerOrder;
    }

    @Transactional
    public CustomerOrder updateDeliveryStatus(String id, DeliveryStatusInput input) {
        log.debug("Request updateDeliveryStatus: {} {}", id, input);
        var customerOrder = customerOrderRepository.findById(id).orElseThrow();
        var previousStatus = customerOrder.getStatus();

        if(DeliveryStatus.REJECTED.equals(input.getDeliveryStatus()) || DeliveryStatus.CANCELLED.equals(input.getDeliveryStatus())) {
            return cancelOrder(id, new CancelOrderInput().setId(id).setReason("Delivery rejected order"));
        }

        customerOrder.setStatus(eventsMapper.asOrderStatus(input.getDeliveryStatus(), previousStatus));
        customerOrder = customerOrderRepository.save(customerOrder);

        // emit events
        var orderStatusEvent = eventsMapper.asOrderStatusUpdated(customerOrder, previousStatus);
        eventsProducer.onOrderStatusUpdated(orderStatusEvent);

        return customerOrder;
    }

    @Transactional
    public CustomerOrder cancelOrder(String id, CancelOrderInput input) {
        log.debug("Request cancelOrder: {} {}", id, input);
        var customerOrder = customerOrderRepository.findById(id).orElseThrow();
        var previousStatus = customerOrder.getStatus();
        if(OrderStatus.CANCELLED.equals(previousStatus)) {
            // do nothing
            return customerOrder;
        }

        customerOrder.setStatus(OrderStatus.CANCELLED);
        customerOrder = customerOrderRepository.save(customerOrder);
        // emit events
        var orderStatusEvent = eventsMapper.orderStatusUpdated(id, OrderStatus.CANCELLED, previousStatus);
        eventsProducer.onOrderStatusUpdated(orderStatusEvent);

        return customerOrder;
    }

    public List<CustomerOrder> searchOrders(OrdersFilter input) {
        log.debug("Request searchOrders: {}", input);

        var customerOrders = customerOrderRepository.findAll();
        return customerOrders;
    }

}
