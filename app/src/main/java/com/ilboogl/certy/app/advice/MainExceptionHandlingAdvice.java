package com.ilboogl.certy.app.advice;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MainExceptionHandlingAdvice {

    @Order
    @ExceptionHandler(Exception.class)
    public ErrorDataModel handleException(Exception exception) {
        return null;
    }

}
