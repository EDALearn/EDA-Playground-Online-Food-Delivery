package io.zenwave360.example.orders.core.domain;

/** Enum for KitchenStatus. */
public enum KitchenStatus {

    REJECTED("REJECTED"), ACCEPTED("ACCEPTED"), IN_PROGRESS("IN_PROGRESS"), READY("READY"), DELIVERED("DELIVERED"),
    CANCELLED("CANCELLED"),;

    private final String value;

    private KitchenStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
