package com.ilboogl.certy.service.certificate;

import com.ilboogl.certy.service.certificate.exception.CertificateNotFoundException;
import com.ilboogl.certy.service.certificate.model.CreateCertificateQuery;
import com.ilboogl.certy.service.certificate.port.CertificatePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
public class CertificateService implements CertificateUseCase {

    private final CertificatePort certificatePort = null;

//    @Autowired
//    CertificateService(CertificatePort certificatePort) {
//        this.certificatePort = certificatePort;
//    }

    @Override
    public Certificate getById(Long id) {
        return certificatePort.findById(id)
                .orElseThrow(() -> new CertificateNotFoundException(id));
    }

    @Override
    public Certificate create(CreateCertificateQuery createQuery) {
        // TODO validate id is 0
        return null;
    }

    @Override
    public Certificate update(Certificate certificate) {
        // TODO validate certificate exists
        return certificatePort.save(certificate);
    }

    @Override
    public void deleteById(Long id) {
        certificatePort.deleteById(id);
    }

}
