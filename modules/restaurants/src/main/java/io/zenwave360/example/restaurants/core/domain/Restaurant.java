package io.zenwave360.example.restaurants.core.domain;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** */
@lombok.Getter
@lombok.Setter
@Document(collection = "restaurant")
public class Restaurant implements Serializable {

    @java.io.Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Version
    private Integer version;

    @Field
    @Indexed(unique = true)
    @NotNull
    @Size(min = 2, max = 250)
    private String name;

    @Field
    @NotNull
    private String phone;

    @Field
    private Address address;

    /*
     * https://vladmihalcea.com/the-best-way-to-implement-equals-hashcode-and-tostring-
     * with-jpa-and-hibernate/
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Restaurant)) {
            return false;
        }
        Restaurant other = (Restaurant) o;
        return id != null && id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
