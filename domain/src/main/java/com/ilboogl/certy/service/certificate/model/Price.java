package com.ilboogl.certy.service.certificate.model;

import javax.validation.constraints.Min;

/**
 * Represents price in dollars.
 */
public class Price {

    @Min(value = 0, message = "price.error.cannot.be.negative")
    private final long cents;

    Price(long cents) {
        this.cents = cents;
    }

    Price(long dollars, long cents) {
        this.cents = dollars * 100 + cents;
    }

    public long getDollars() {
        return cents / 100;
    }

    public long getCents() {
        return cents % 100;
    }

}
