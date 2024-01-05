package io.zenwave360.example.orders.core.implementation;

import io.zenwave360.example.orders.core.domain.*;
import io.zenwave360.example.orders.core.implementation.mappers.*;
import io.zenwave360.example.orders.core.inbound.*;
import io.zenwave360.example.orders.core.inbound.dtos.*;
import io.zenwave360.example.orders.core.outbound.mongodb.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Service Implementation for managing [CustomerOrder]. */
@Service
@Transactional(readOnly = true)
public class OrdersServiceImpl implements OrdersService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final CustomerOrderMapper customerOrderMapper = CustomerOrderMapper.INSTANCE;

    private final CustomerOrderRepository customerOrderRepository;

    /** Constructor. */
    public OrdersServiceImpl(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    public CustomerOrder getOrder(String id) {
        log.debug("Request getOrder: {}", id);
        var customerOrder = customerOrderRepository.findById(id).orElseThrow();
        // TODO: implement this method
        customerOrder = customerOrderRepository.save(customerOrder);
        return customerOrder;
    }

    public CustomerOrder createOrder(CustomerOrder input) {
        log.debug("Request createOrder: {}", input);
        var customerOrder = customerOrderMapper.update(new CustomerOrder(), input);
        // TODO: implement this method
        customerOrder = customerOrderRepository.save(customerOrder);
        return customerOrder;
    }

    public CustomerOrder updateOrder(String id, CustomerOrder input) {
        log.debug("Request updateOrder: {}", id);
        var customerOrder = customerOrderRepository.findById(id).orElseThrow();
        customerOrder = customerOrderMapper.update(customerOrder, input);
        // TODO: implement this method
        customerOrder = customerOrderRepository.save(customerOrder);
        return customerOrder;
    }

    public CustomerOrder updateKitchenStatus(String id, KitchenStatusInput input) {
        log.debug("Request updateKitchenStatus: {}", id);
        var customerOrder = customerOrderRepository.findById(id).orElseThrow();
        customerOrder = customerOrderMapper.update(customerOrder, input);
        // TODO: implement this method
        customerOrder = customerOrderRepository.save(customerOrder);
        return customerOrder;
    }

    public CustomerOrder updateDeliveryStatus(String id, DeliveryStatusInput input) {
        log.debug("Request updateDeliveryStatus: {}", id);
        var customerOrder = customerOrderRepository.findById(id).orElseThrow();
        customerOrder = customerOrderMapper.update(customerOrder, input);
        // TODO: implement this method
        customerOrder = customerOrderRepository.save(customerOrder);
        return customerOrder;
    }

    public CustomerOrder cancelOrder(String id, CancelOrderInput input) {
        log.debug("Request cancelOrder: {}", id);
        var customerOrder = customerOrderRepository.findById(id).orElseThrow();
        customerOrder = customerOrderMapper.update(customerOrder, input);
        // TODO: implement this method
        customerOrder = customerOrderRepository.save(customerOrder);
        return customerOrder;
    }

    public List<CustomerOrder> searchOrders(OrdersFilter input) {
        log.debug("Request searchOrders: {}", input);
        var results = customerOrderRepository.findAll(); // TODO: implement this filter
        return results;
    }

}
