package io.zenwave360.example.delivery.core.domain;

/** Enum for DeliveryStatus. */
public enum DeliveryStatus {

    ACCEPTED("ACCEPTED"), REJECTED("REJECTED"), IN_PROGRESS("IN_PROGRESS"), READY("READY"), DELIVERED("DELIVERED"),
    CANCELLED("CANCELLED"),;

    private final String value;

    private DeliveryStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
