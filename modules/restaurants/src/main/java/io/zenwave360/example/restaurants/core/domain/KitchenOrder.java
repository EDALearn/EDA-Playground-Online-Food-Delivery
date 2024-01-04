package io.zenwave360.example.restaurants.core.domain;

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
@Document(collection = "kitchen_order")
public class KitchenOrder implements Serializable {

    @java.io.Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Version
    private Integer version;

    @Field
    @NotNull
    private String restaurantId;

    @Field
    @NotNull
    private LocalDateTime date;

    @Field
    @NotNull
    private List<MenuItem> items = new ArrayList<>();

    @Field
    @NotNull
    private KitchenOrderStatus status;

    @Field
    private CustomerDetails customer;

    public KitchenOrder addItems(MenuItem items) {
        this.items.add(items);
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
        if (!(o instanceof KitchenOrder)) {
            return false;
        }
        KitchenOrder other = (KitchenOrder) o;
        return id != null && id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
