package com.ilboogl.certy.service.certificate;

import com.ilboogl.certy.service.certificate.model.CreateCertificateQuery;

import javax.validation.Valid;

public interface CertificateUseCase {
    Certificate getById(Long id);
    Certificate create(@Valid CreateCertificateQuery createQuery);
    Certificate update(Certificate certificate);
    void deleteById(Long id);
}
