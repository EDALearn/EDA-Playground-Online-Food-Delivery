package io.zenwave360.example.orders.core.domain;

/** Enum for OrderStatus. */
public enum OrderStatus {

    RECEIVED("RECEIVED"), KITCHEN_ACCEPTED("KITCHEN_ACCEPTED"), DELIVERY_ACCEPTED("DELIVERY_ACCEPTED"),
    CONFIRMED("CONFIRMED"), KITCHEN_IN_PROGRESS("KITCHEN_IN_PROGRESS"), KITCHEN_READY("KITCHEN_READY"),
    KITCHEN_DELIVERED("KITCHEN_DELIVERED"), ON_DELIVERY("ON_DELIVERY"), DELIVERED("DELIVERED"), CANCELLED("CANCELLED"),;

    private final String value;

    private OrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
