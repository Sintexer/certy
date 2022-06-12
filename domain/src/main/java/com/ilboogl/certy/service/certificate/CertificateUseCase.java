package com.ilboogl.certy.service.certificate;

public interface CertificateUseCase {
    Certificate getById(Long id);
    Certificate create(Certificate certificate);
    Certificate update(Certificate certificate);
    void deleteById(Long id);
}
