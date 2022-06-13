package com.ilboogl.certy.app.advice;

import com.ilboogl.certy.service.mesage.MessageUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@Slf4j
@ControllerAdvice
public class MainExceptionHandlingAdvice {

    private final MessageUseCase messageUseCase;

    @Autowired
    MainExceptionHandlingAdvice(MessageUseCase messageUseCase) {
        this.messageUseCase = messageUseCase;
    }

    @Order
    @ExceptionHandler(Exception.class)
    public ErrorDataModel handleException(Exception exception, Locale locale) {
        log.error(messageUseCase.get(ErrorMessageConstants.INTERNAL_ERROR), exception);
        return ErrorDataModel.builder()
                .appErrorCode(ApplicationErrorCode.INTERNAL_ERROR)
                .httpErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(messageUseCase.get(ErrorMessageConstants.INTERNAL_ERROR, locale))
                .build();
    }

}
