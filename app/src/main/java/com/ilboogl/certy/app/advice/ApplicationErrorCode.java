package com.ilboogl.certy.app.advice;

import org.springframework.http.HttpStatus;

/**
 * This enum represents different application error codes.
 * All codes are build by the pattern: first 3 digits are http error code, last three are error identifier.
 */
public enum ApplicationErrorCode {
    VALIDATION_ERROR(HttpStatus.BAD_REQUEST.value(), 1),
    CERTIFICATE_NOT_FOUND(HttpStatus.NOT_FOUND.value(), 100),
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), 900);

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
