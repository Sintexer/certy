package com.ilboogl.certy.app.advice;

import lombok.Getter;

/**
 * This enum represents different application error codes.
 * All codes are build by the pattern: first 3 digits are http error code, last three are error identifier.
 */
@Getter
public enum ApplicationErrorCode {
    CERTIFICATE_NOT_FOUND(404001);

    private final int errorCode;

    ApplicationErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
