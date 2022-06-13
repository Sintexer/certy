package com.ilboogl.certy.app.advice;

import lombok.Getter;

/**
 * This enum represents different application error codes.
 * All codes are build by the pattern: first 3 digits are http error code, last three are error identifier.
 */
public enum ApplicationErrorCode {
    CERTIFICATE_NOT_FOUND(404, 1),
    INTERNAL_ERROR(500, 1);

    private static final String CODE_FORMAT = "%03d%03d";

    private final int httpCode;
    private final int errorCode;

    ApplicationErrorCode(int httpCode, int errorCode) {
        this.errorCode = errorCode;
        this.httpCode = httpCode;
    }

    public Integer value() {
        return Integer.parseInt(toString());
    }


    @Override
    public String toString() {
        return String.format(CODE_FORMAT, httpCode, errorCode);
    }
}
