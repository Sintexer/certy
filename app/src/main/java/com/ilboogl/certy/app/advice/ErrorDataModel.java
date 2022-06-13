package com.ilboogl.certy.app.advice;

import lombok.Data;

/**
 * Application error data description model. Contains error message, http and app error codes.
 */
@Data
public class ErrorDataModel {
    private final int httpErrorCode;
    private final String message;
    private final ApplicationErrorCode appErrorCode;
}
