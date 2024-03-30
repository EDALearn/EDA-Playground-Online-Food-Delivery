package io.zenwave360.example.delivery.adapters.web;

import io.zenwave360.example.delivery.adapters.web.model.*;
import io.zenwave360.example.delivery.config.ServicesInMemoryConfig;
import java.math.*;
import java.time.*;
import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Test controller for DeliveryApiController. */
public class DeliveryApiControllerTest {

  private final Logger log = LoggerFactory.getLogger(getClass());

  ServicesInMemoryConfig context = new ServicesInMemoryConfig();

  DeliveryApiController controller = new DeliveryApiController().setDeliveryService(context.deliveryService());

  @BeforeEach
  void setUp() {
    context.reloadTestData();
  }

  @Test
  public void updateDeliveryStatusTest() {
    String orderId = null;
    DeliveryStatusInputDTO reqBody = null;
    var response = controller.updateDeliveryStatus(orderId, reqBody);
    Assertions.assertEquals(200, response.getStatusCode().value());
  }

  @Test
  public void listDeliveriesTest() {
    Optional<Integer> page = null;
    Optional<Integer> limit = null;
    Optional<List<String>> sort = null;
    var response = controller.listDeliveries(page, limit, sort);
    Assertions.assertEquals(200, response.getStatusCode().value());
  }
}
