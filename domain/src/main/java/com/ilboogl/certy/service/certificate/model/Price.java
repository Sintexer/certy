package com.ilboogl.certy.service.certificate.model;

import lombok.ToString;

import javax.validation.constraints.Min;

/**
 * Represents price in dollars.
 */
@ToString
public class Price {

    @Min(value = 0, message = "price.error.cannot.be.negative")
    private final long cents;

    public Price(@Min(0) long cents) {
        this.cents = cents;
    }

    public Price(@Min(0) long dollars, @Min(0) long cents) {
        this.cents = dollars * 100 + cents;
    }

    public long getDollars() {
        return cents / 100;
    }

    public long getCents() {
        return cents % 100;
    }



}
