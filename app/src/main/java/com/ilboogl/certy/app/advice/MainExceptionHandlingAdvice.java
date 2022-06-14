package com.ilboogl.certy.app.advice;

import com.ilboogl.certy.service.mesage.MessageUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.Locale;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class MainExceptionHandlingAdvice {

    private final MessageUseCase messageUseCase;

    @Autowired
    MainExceptionHandlingAdvice(MessageUseCase messageUseCase) {
        this.messageUseCase = messageUseCase;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorsDataModel handleControllerMethodValidationError(MethodArgumentNotValidException exception) {
        log.trace("Validation error", exception);
        var errors = exception.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> new ValidationErrorsDataModel.ValidationError(
                        fieldError.getField(),
                        fieldError.getDefaultMessage(),
                        String.valueOf(fieldError.getRejectedValue())))
                .collect(Collectors.toList());

        return ValidationErrorsDataModel.builder()
                .appErrorCode(ApplicationErrorCode.VALIDATION_ERROR.value())
                .httpErrorCode(HttpStatus.BAD_REQUEST.value())
                .message(messageUseCase.get(ErrorMessageConstants.VALIDATION_ERROR))
                .errors(errors)
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    public ValidationErrorsDataModel handleConstraintViolationError(ConstraintViolationException exception) {
        log.trace("Validation error", exception);
        var errors = exception.getConstraintViolations().stream()
                .map(violation -> new ValidationErrorsDataModel.ValidationError(
                        violation.getPropertyPath().toString(),
                        violation.getMessage(),
                        String.valueOf(violation.getInvalidValue())))
                .collect(Collectors.toList());

        return ValidationErrorsDataModel.builder()
                .appErrorCode(ApplicationErrorCode.VALIDATION_ERROR.value())
                .httpErrorCode(HttpStatus.BAD_REQUEST.value())
                .message(messageUseCase.get(ErrorMessageConstants.VALIDATION_ERROR))
                .errors(errors)
                .build();
    }


    @Order
    @ExceptionHandler(Exception.class)
    public ErrorDataModel handleException(Exception exception, Locale locale) {
        log.error(messageUseCase.get(ErrorMessageConstants.INTERNAL_ERROR), exception);
        return ErrorDataModel.builder()
                .appErrorCode(ApplicationErrorCode.INTERNAL_ERROR.value())
                .httpErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(messageUseCase.get(ErrorMessageConstants.INTERNAL_ERROR, locale))
                .build();
    }

}
