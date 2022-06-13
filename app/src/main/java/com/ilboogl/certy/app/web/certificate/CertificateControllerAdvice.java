package com.ilboogl.certy.app.web.certificate;

import com.ilboogl.certy.app.advice.ApplicationErrorCode;
import com.ilboogl.certy.app.advice.ErrorDataModel;
import com.ilboogl.certy.service.certificate.exception.CertificateNotFoundException;
import com.ilboogl.certy.service.mesage.MessageUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

/**
 * Handles Certificate-related exception.
 */
@Slf4j
@ControllerAdvice
public class CertificateControllerAdvice {

    public static final String CERTIFICATE_NOT_FOUND_MESSAGE = "certificate.error.not.found";

    private final MessageUseCase messageUseCase;

    @Autowired
    CertificateControllerAdvice(MessageUseCase messageUseCase) {
        this.messageUseCase = messageUseCase;
    }

    @ExceptionHandler(CertificateNotFoundException.class)
    public ErrorDataModel handleCertificateNotFoundException(CertificateNotFoundException exception, Locale locale) {
        String errorMessage = messageUseCase.get(CERTIFICATE_NOT_FOUND_MESSAGE, locale, exception.getCertificateId());
        log.error(errorMessage);
        return ErrorDataModel.notFound(errorMessage, ApplicationErrorCode.CERTIFICATE_NOT_FOUND);
    }


}
