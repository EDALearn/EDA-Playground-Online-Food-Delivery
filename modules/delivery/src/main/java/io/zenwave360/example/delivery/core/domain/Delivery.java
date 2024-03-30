package io.zenwave360.example.delivery.core.domain;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** */
@lombok.Getter
@lombok.Setter
@Document(collection = "delivery")
public class Delivery implements Serializable {

    @java.io.Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Version
    private Integer version;

    @Field
    @NotNull
    private String orderId;

    @Field
    private Customer customer;

    @Field
    private Restaurant restaurant;

    @Field
    private List<OrderItem> orderItems = new ArrayList<>();

    @Field
    @NotNull
    private DeliveryOrderStatus status;

    public Delivery addOrderItems(OrderItem orderItems) {
        this.orderItems.add(orderItems);
        return this;
    }

    /*
     * https://vladmihalcea.com/the-best-way-to-implement-equals-hashcode-and-tostring-
     * with-jpa-and-hibernate/
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Delivery)) {
            return false;
        }
        Delivery other = (Delivery) o;
        return id != null && id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
