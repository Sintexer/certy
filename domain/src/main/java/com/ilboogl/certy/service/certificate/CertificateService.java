package com.ilboogl.certy.service.certificate;

import com.ilboogl.certy.service.certificate.exception.CertificateNotFoundException;
import com.ilboogl.certy.service.certificate.port.CertificatePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificateService implements CertificateUseCase {

    private final CertificatePort certificatePort;

    @Autowired
    CertificateService(CertificatePort certificatePort) {
        this.certificatePort = certificatePort;
    }

    @Override
    public Certificate getById(Long id) {
        return certificatePort.findById(id)
                .orElseThrow(() -> new CertificateNotFoundException(id));
    }

    @Override
    public Certificate create(Certificate certificate) {
        // TODO validate id is 0
        return certificatePort.save(certificate);
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
