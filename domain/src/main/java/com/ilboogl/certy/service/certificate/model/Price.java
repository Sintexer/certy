package com.ilboogl.certy.service.certificate.model;

import lombok.ToString;

import javax.validation.constraints.Min;

/**
 * Represents price in dollars.
 */
@ToString
public class Price {

    @Min(value = 0, message = "{price.error.cannot.be.negative}")
    private final long value;

    public Price(@Min(0) long value) {
        this.value = value;
    }

    public Price(@Min(0) long dollars, @Min(0) long value) {
        this.value = dollars * 100 + value;
    }

    public long getDollars() {
        return value / 100;
    }

    public long getCents() {
        return value % 100;
    }

    public long getValue() {
        return value;
    }



}
