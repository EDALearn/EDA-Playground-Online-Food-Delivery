package io.zenwave360.example.restaurants.core.domain;

/** Enum for KitchenOrderStatus. */
public enum KitchenOrderStatus {

    RECEIVED("RECEIVED"), IN_PROGRESS("IN_PROGRESS"), READY("READY"), DELIVERED("DELIVERED"),;

    private final String value;

    private KitchenOrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
