package com.ilboogl.certy.service.certificate.exception;

import lombok.Getter;

/**
 * Certificate not found exception class.
 */
public class CertificateNotFoundException extends CertificateServiceException {

    @Getter
    private final Long certificateId;

    public CertificateNotFoundException(Long certificateId) {
        this.certificateId = certificateId;
    }
}
