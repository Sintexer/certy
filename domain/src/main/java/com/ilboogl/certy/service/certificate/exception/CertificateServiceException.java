package com.ilboogl.certy.service.certificate.exception;

/**
 * Base certificate service exception class.
 */
public class CertificateServiceException extends RuntimeException {
    public CertificateServiceException() {
        super();
    }

    public CertificateServiceException(String message) {
        super(message);
    }

    public CertificateServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CertificateServiceException(Throwable cause) {
        super(cause);
    }
}
