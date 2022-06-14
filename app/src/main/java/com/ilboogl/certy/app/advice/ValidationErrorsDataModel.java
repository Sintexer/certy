package com.ilboogl.certy.app.advice;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Error data model that provides information about validation error.
 */
@Data
@Builder
public class ValidationErrorsDataModel {
    private int httpErrorCode;
    private String message;
    private int appErrorCode;
    private List<ValidationError> errors;

    @Data
    public static class ValidationError {
        private final String path;
        private final String message;
        private final String rejectedValue;
    }
}
