package io.zenwave360.example.customers.core.domain;

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
@Document(collection = "customer")
public class Customer implements Serializable {

    @java.io.Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Version
    private Integer version;

    /** first name javadoc comment */
    @Field
    @NotNull
    @Size(min = 2, max = 250)
    private String firstName;

    /** last name javadoc comment */
    @Field
    @NotNull
    @Size(min = 2, max = 250)
    private String lastName;

    /** email javadoc comment */
    @Field
    @Indexed(unique = true)
    @NotNull
    private String email;

    /** address is a nested entity */
    @Field
    private List<Address> addresses = new ArrayList<>();

    public Customer addAddresses(Address addresses) {
        this.addresses.add(addresses);
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
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) o;
        return id != null && id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
