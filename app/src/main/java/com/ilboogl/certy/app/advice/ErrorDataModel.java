package com.ilboogl.certy.app.advice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Application error data description model. Contains error message, http and app error codes.
 */
@Data
@Builder
@AllArgsConstructor
public class ErrorDataModel {
    private final int httpErrorCode;
    private final String message;
    private final ApplicationErrorCode appErrorCode;

    public static ErrorDataModel notFound(String message, ApplicationErrorCode appErrorCode) {
        return new ErrorDataModel(HttpStatus.NOT_FOUND.value(), message, appErrorCode);
    }
}
