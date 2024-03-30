package io.zenwave360.example.delivery.adapters.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@org.springframework.transaction.annotation.Transactional
public abstract class BaseConsumerTest {

    @Autowired
    protected WebApplicationContext context;

}
