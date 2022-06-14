package com.ilboogl.certy.app.web.certificate;

import com.ilboogl.certy.service.certificate.Certificate;
import com.ilboogl.certy.service.certificate.CertificateUseCase;
import com.ilboogl.certy.service.certificate.model.CreateCertificateQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/certificates")
public class CertificateController {

    private final CertificateUseCase certificateUseCase;

    @Autowired
    CertificateController(CertificateUseCase certificateUseCase) {
        this.certificateUseCase = certificateUseCase;
    }

    @PostMapping
    public Certificate createCertificate(
            @RequestBody @Valid CreateCertificateQuery createQuery) {
        return certificateUseCase.create(createQuery);
    }

    @GetMapping
    public Certificate getAllCertificates() {
        return null;
    }

    @GetMapping("/{id}")
    public Certificate getCertificate(@PathVariable Long id) {
        return null;
    }

}
