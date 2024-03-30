package io.zenwave360.example.orders.core.inbound.dtos;

/** Enum for DeliveryStatus. */
public enum DeliveryStatus {

    REJECTED("REJECTED"), ACCEPTED("ACCEPTED"), IN_PROGRESS("IN_PROGRESS"), DELIVERED("DELIVERED"),
    CANCELLED("CANCELLED"),;

    private final String value;

    private DeliveryStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
